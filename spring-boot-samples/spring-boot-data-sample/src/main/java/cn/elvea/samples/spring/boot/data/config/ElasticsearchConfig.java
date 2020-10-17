package cn.elvea.samples.spring.boot.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Elasticsearch Configuration
 *
 * @author elvea
 */
@Configuration
@EnableElasticsearchRepositories("cn.elvea.samples.spring.boot.data.elasticsearch.repository")
public class ElasticsearchConfig {
}
