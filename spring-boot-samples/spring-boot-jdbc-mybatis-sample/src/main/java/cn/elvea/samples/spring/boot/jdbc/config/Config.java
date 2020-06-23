package cn.elvea.samples.spring.boot.jdbc.config;

import cn.elvea.samples.spring.boot.jdbc.mybatis.MyBatisNamespaceStrategy;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.DataAccessStrategy;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.mybatis.MyBatisDataAccessStrategy;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

/**
 * Config
 *
 * @author elvea
 */
@EnableJdbcRepositories("cn.elvea.samples.spring.boot.jdbc.repository")
@MapperScan("cn.elvea.samples.spring.boot.jdbc.mapper")
@Configuration(proxyBeanMethods = false)
public class Config extends AbstractJdbcConfiguration {

    private @Autowired
    SqlSession session;

    @Override
    @Bean
    public DataAccessStrategy dataAccessStrategyBean(NamedParameterJdbcOperations operations,
                                                     JdbcConverter jdbcConverter,
                                                     JdbcMappingContext context,
                                                     Dialect dialect) {
        return MyBatisDataAccessStrategy.createCombinedAccessStrategy(
                context, jdbcConverter, operations, session,
                new MyBatisNamespaceStrategy(), dialect);
    }
}
