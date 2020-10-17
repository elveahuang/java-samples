package cn.elvea.samples.spring.boot.data.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis Configuration
 *
 * @author elvea
 */
@Configuration
@MapperScan("cn.elvea.samples.spring.boot.data.mybatis.mapper")
public class MyBatisConfig {
}
