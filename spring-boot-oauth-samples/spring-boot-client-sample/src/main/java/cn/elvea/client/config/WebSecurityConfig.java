package cn.elvea.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfig
 *
 * @author elvea
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/oauth2/**").permitAll()
                .antMatchers("/oauth/callback/*").permitAll()
                .antMatchers("/login/oauth").permitAll()
                .antMatchers("/login/oauth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login(auth -> auth
                        .loginPage("/login/oauth")
                        .authorizationEndpoint(authorization -> authorization.baseUri("/login/oauth/authorization"))
                        .redirectionEndpoint(redirection -> redirection.baseUri("/login/oauth/callback/*"))
                );
    }

}
