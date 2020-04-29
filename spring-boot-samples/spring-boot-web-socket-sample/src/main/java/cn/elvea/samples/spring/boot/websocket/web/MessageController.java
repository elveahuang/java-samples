package cn.elvea.samples.spring.boot.websocket.web;

import cn.elvea.samples.spring.boot.websocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * MessageController
 *
 * @author elvea
 */
@RestController
public class MessageController {

    private final SimpMessagingTemplate messagingTemplate;

    public MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/message")
    public void greeting(Message message) {
        messagingTemplate.convertAndSend("/message", message);
    }

}
