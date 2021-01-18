package cn.elvea.authorization.server.config;

import cn.elvea.authorization.server.support.SubjectAttributeUserTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.InMemoryApprovalStore;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.security.KeyPair;

/**
 * 认证服务器配置
 *
 * @author elvea
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    private final KeyPair keyPair;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthorizationServerConfig(
            AuthenticationConfiguration authenticationConfiguration,
            KeyPair keyPair,
            PasswordEncoder passwordEncoder
    ) throws Exception {
        this.passwordEncoder = passwordEncoder;
        this.keyPair = keyPair;
        this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(this.authenticationManager);
        endpoints.tokenStore(tokenStore());
        endpoints.accessTokenConverter(accessTokenConverter());
        // 默认情况下，只有第一次请求到的Refresh Token可用，
        // 后续刷新后获取到的Refresh Token都无法使用的
        // 这里可以根据实际情况做选择
        endpoints.reuseRefreshTokens(false);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("webapp")
                .secret(this.passwordEncoder.encode("webapp"))
                .authorizedGrantTypes("password", "client_credentials", "authorization_code", "refresh_token", "implicit")
                .authorities("ROLE_USER")
                .scopes("message:read", "message:write", "user")
                .resourceIds("webapp", "authorization-server")
                .redirectUris("http://127.0.0.1:8080/authorized", "http://127.0.0.1:8080/login/oauth/callback/authorization-server")
                .accessTokenValiditySeconds(60);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public ApprovalStore approvalStore() {
        return new InMemoryApprovalStore();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(this.keyPair);

        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(new SubjectAttributeUserTokenConverter());
        converter.setAccessTokenConverter(accessTokenConverter);

        return converter;
    }

}
