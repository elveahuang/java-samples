package cn.elvea.authorization.server.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.security.oauth2.server.authorization.config.ProviderSettings.*;

/**
 * 认证服务器配置
 *
 * @author elvea
 */
@Configuration(proxyBeanMethods = false)
@Import(OAuth2AuthorizationServerConfiguration.class)
public class AuthorizationServerConfiguration {

    private static final char[] KEY_STORE_PASSWORD = "jwttest".toCharArray();

    private static final String KEY_ALIAS = "jwttest";

    private final PasswordEncoder passwordEncoder;

    public AuthorizationServerConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("webapp")
                .clientSecret("webapp")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .clientAuthenticationMethod(ClientAuthenticationMethod.POST)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .redirectUri("http://127.0.0.1:8080/login/oauth/callback/webapp")
                .redirectUri("http://localhost:8080/login/oauth/callback/webapp")
                .redirectUri("http://127.0.0.1:8080/authorized")
                .redirectUri("http://localhost:8080/authorized")
                .scope(OidcScopes.OPENID)
                .scope("message:read")
                .scope("message:write")
                .clientSettings(clientSettings -> clientSettings.requireUserConsent(true))
                .build();
        return new InMemoryRegisteredClientRepository(registeredClient);
    }

    @Bean
    public KeyStore keyStore() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new ClassPathResource("jwt/jwt.jks").getInputStream(), KEY_STORE_PASSWORD);
        return keyStore;
    }

    @Bean
    public JWKSet jwkSet(KeyStore keyStore) throws Exception {
        return JWKSet.load(keyStore, name -> KEY_STORE_PASSWORD);
    }

    @Bean
    public KeyPair keyPair(KeyStore keyStore) throws Exception {
        RSAPrivateCrtKey key = (RSAPrivateCrtKey) keyStore.getKey(KEY_ALIAS, KEY_STORE_PASSWORD);
        RSAPublicKeySpec spec = new RSAPublicKeySpec(key.getModulus(), key.getPublicExponent());
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);
        return new KeyPair(publicKey, key);
    }

    @Bean
    public JwtDecoder jwtDecoder(KeyPair keyPair) {
        return NimbusJwtDecoder.withPublicKey((RSAPublicKey) keyPair.getPublic()).build();
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource(JWKSet jwkSet) {
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    @Bean
    public ProviderSettings providerSettings() {
        Map<String, Object> settings = new HashMap<>();
        settings.put(AUTHORIZATION_ENDPOINT, "/oauth/authorize");
        settings.put(TOKEN_ENDPOINT, "/oauth/token");
        settings.put(JWK_SET_ENDPOINT, "/oauth/jwks");
        settings.put(TOKEN_REVOCATION_ENDPOINT, "/oauth/revoke");
        return new ProviderSettings(settings).issuer("http://192.168.0.5:8081");
    }

}
