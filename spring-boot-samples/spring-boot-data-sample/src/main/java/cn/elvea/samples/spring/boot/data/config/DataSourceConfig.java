package cn.elvea.samples.spring.boot.data.config;

import cn.elvea.samples.spring.boot.data.config.properties.CustomProperties;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 数据源配置
 *
 * @author dfox
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({CustomProperties.class})
public class DataSourceConfig {

    @Autowired
    private CustomProperties customProperties;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.master")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    @ConditionalOnProperty(name = "app.master-slave-enable", havingValue = "true")
    public DataSourceProperties slaveDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource() throws SQLException {
        if (customProperties.isMasterSlaveEnable()) {
            log.debug("creating master-slave-datasource...");
            Map<String, DataSource> dataSourceMap = new HashMap<>();
            dataSourceMap.put("masterDataSource", createHikariDataSource(masterDataSourceProperties()));
            dataSourceMap.put("slaveDataSource", createHikariDataSource(slaveDataSourceProperties()));

            MasterSlaveRuleConfiguration configuration = new MasterSlaveRuleConfiguration(
                    "masterSlaveDataSource",
                    "masterDataSource",
                    Collections.singletonList(
                            "slaveDataSource"
                    ));

            Properties properties = new Properties();
            properties.setProperty("sql.show", "true");
            properties.setProperty("sql-show", "true");

            return MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, configuration, properties);
        } else {
            log.debug("creating datasource...");
            return createHikariDataSource(masterDataSourceProperties());
        }
    }

    private DataSource createHikariDataSource(DataSourceProperties properties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }

}
