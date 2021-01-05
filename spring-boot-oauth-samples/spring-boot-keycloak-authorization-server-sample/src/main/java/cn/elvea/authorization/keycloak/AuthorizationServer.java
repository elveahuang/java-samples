package cn.elvea.authorization.keycloak;

import cn.elvea.authorization.keycloak.properties.KeycloakServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.common.Version;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

/**
 * AuthorizationServer
 *
 * @author elvea
 */
@Slf4j
@SpringBootApplication
public class AuthorizationServer {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServer.class, args);
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(
            ServerProperties serverProperties,
            KeycloakServerProperties keycloakServerProperties
    ) {
        return (evt) -> {
            log.info("Embedded Keycloak started.");
            log.info("Keycloak version: {}", Version.VERSION);
            log.info("Context Path : {}", keycloakServerProperties.getContextPath());
            log.info("Server Port : {}", serverProperties.getPort());
        };
    }

}
