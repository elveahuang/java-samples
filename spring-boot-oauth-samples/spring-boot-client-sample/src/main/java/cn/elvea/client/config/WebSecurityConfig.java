package cn.elvea.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * SecurityConfig
 *
 * @author elvea
 */
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/webjars/**");
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests
                        .antMatchers("/", "/login/oauth", "/login/oauth/**").permitAll()
                        .anyRequest().authenticated()
        ).oauth2Login(auth ->
                auth
                        .loginPage("/login/oauth")
                        .authorizationEndpoint(authorization -> authorization.baseUri("/login/oauth/authorization"))
                        .redirectionEndpoint(redirection -> redirection.baseUri("/login/oauth/callback/*"))
        ).oauth2Client(withDefaults());
        return http.build();
    }

}
