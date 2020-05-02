package cn.elvea.samples.spring.boot.websocket.config;

import cn.elvea.samples.spring.boot.websocket.message.SocketMessage;
import cn.elvea.samples.spring.boot.websocket.message.SocketMessageDelegate;
import cn.elvea.samples.spring.boot.websocket.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StringUtils;

/**
 * Config
 *
 * @author elvea
 */
@Slf4j
@Configuration
@EnableScheduling
public class Config {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public Jackson2JsonRedisSerializer<?> jacksonSerializer() {
        return new Jackson2JsonRedisSerializer<>(Object.class);
    }

    @Bean
    RedissonClient redissonClient() {
        org.redisson.config.Config config = new org.redisson.config.Config();
        if (StringUtils.isEmpty(redisProperties.getPassword())) {
            config.useSingleServer()
                    .setAddress("redis://" + redisProperties.getHost() + ":" + redisProperties.getPort())
                    .setDatabase(redisProperties.getDatabase());
        } else {
            config.useSingleServer()
                    .setAddress("redis://" + redisProperties.getHost() + ":" + redisProperties.getPort())
                    .setPassword(redisProperties.getPassword())
                    .setDatabase(redisProperties.getDatabase());
        }
        try {
            log.debug("Create RedissonClient [{}] [{}] [{}]...",
                    redisProperties.getHost(), redisProperties.getPort(), redisProperties.getDatabase());

            return Redisson.create(config);
        } catch (Exception e) {
            log.error("Create RedissonClient [{}] [{}] [{}] failed. Exception : ",
                    redisProperties.getHost(), redisProperties.getPort(), redisProperties.getDatabase(), e);
            return null;
        }
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory,
                                                       Jackson2JsonRedisSerializer<?> jacksonSerializer) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setValueSerializer(jacksonSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public MessageListenerAdapter socketMessageListenerAdapter(SocketMessageDelegate socketMessageDelegate) {
        MessageListenerAdapter adapter = new MessageListenerAdapter();
        adapter.setDelegate(socketMessageDelegate);
        adapter.setSerializer(new Jackson2JsonRedisSerializer<>(SocketMessage.class));
        return adapter;
    }

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter socketMessageListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(socketMessageListenerAdapter, new ChannelTopic(RedisService.WEB_SOCKET_TOPIC));
        return container;
    }

}
