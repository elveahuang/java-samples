package cn.elvea.samples.spring.boot.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;

/**
 * Spring Data JDBC Configuration
 *
 * @author elvea
 */
@Configuration
@EnableJdbcRepositories("cn.elvea.samples.spring.boot.data.jdbc.repository")
@Import(MyBatisJdbcConfiguration.class)
public class JdbcConfig {
}
