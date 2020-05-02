package cn.elvea.samples.spring.boot.websocket.service.impl;

import cn.elvea.samples.spring.boot.websocket.message.SocketMessage;
import cn.elvea.samples.spring.boot.websocket.service.RedisService;
import cn.elvea.samples.spring.boot.websocket.service.WebSocketService;
import cn.elvea.samples.spring.boot.websocket.service.WebSocketSessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * WebSocketService
 *
 * @author elvea
 */
@Service
@Slf4j
public class WebSocketServiceImpl implements WebSocketService {

    @Autowired
    private WebSocketSessionService webSocketSessionService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public RedisService redisService;

    /**
     * @see WebSocketService#sendMessage()
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void sendMessage() {
        log.debug("sending message......");
        messagingTemplate.convertAndSend("/message", new Date());
        messagingTemplate.convertAndSend("/socket/message", new Date());

        SocketMessage socketMessage = new SocketMessage();
        socketMessage.setMessage(UUID.randomUUID().toString());
        this.redisService.sendMessage(socketMessage);
    }

    /**
     * @see WebSocketService#sendMessage(SocketMessage)
     */
    public void sendMessage(SocketMessage socketMessage) {
        log.debug("sending message......");
        this.webSocketSessionService.getWsSessions();
        messagingTemplate.convertAndSend("/message", socketMessage);
        messagingTemplate.convertAndSend("/socket/message", socketMessage);
    }

}
