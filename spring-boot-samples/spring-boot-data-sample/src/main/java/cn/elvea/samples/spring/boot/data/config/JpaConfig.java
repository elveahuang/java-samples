package cn.elvea.samples.spring.boot.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Jpa & Hibernate Configuration
 *
 * @author elvea
 */
@Configuration
@EnableJpaRepositories("cn.elvea.samples.spring.boot.data.jpa.repository")
public class JpaConfig {
}
