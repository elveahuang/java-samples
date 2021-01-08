package cn.elvea.authorization.server.config;

import com.nimbusds.jose.jwk.JWKSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/**
 * 安全基础配置
 *
 * @author elvea
 */
@Configuration
public class SecurityCommonConfig {

    private static final char[] KEY_STORE_PASSWORD = "jwttest".toCharArray();

    private static final String KEY_ALIAS = "jwttest";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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
    public UserDetailsService users(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
