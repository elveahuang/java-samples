package cn.elvea.samples.spring.boot.data.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * ElasticSearch Configuration
 *
 * @author elvea
 */
@Slf4j
@Configuration
@EnableElasticsearchRepositories("cn.elvea.samples.spring.boot.data.elasticsearch.repository")
public class ElasticSearchConfig {
}
