package cn.elvea.samples.spring.boot.websocket.service.impl;

import cn.elvea.samples.spring.boot.websocket.message.SocketMessage;
import cn.elvea.samples.spring.boot.websocket.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * RedisServiceImpl
 *
 * @author elvea
 */
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void sendMessage(SocketMessage socketMessage) {
        this.redisTemplate.convertAndSend(RedisService.WEB_SOCKET_TOPIC, socketMessage);
    }

}
