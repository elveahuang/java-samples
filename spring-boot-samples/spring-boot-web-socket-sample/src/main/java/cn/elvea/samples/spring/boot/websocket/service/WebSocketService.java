package cn.elvea.samples.spring.boot.websocket.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * WebSocketService
 *
 * @author elvea
 */
@Slf4j
@Service
public class WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void sendMessage() {
        log.debug("sending message......");
        messagingTemplate.convertAndSend("/message", new Date());
        messagingTemplate.convertAndSend("/text", new Date());
    }

}
