package cn.elvea.samples.spring.boot.oauth.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfig
 *
 * @author elvea
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a
                .antMatchers("/favicon.ico", "/", "/error", "/webjars/**").permitAll()
                .antMatchers("/login**").permitAll()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
        ).oauth2Login();
    }

}
