package cn.elvea.samples.spring.boot.websocket.message;

import cn.elvea.samples.spring.boot.websocket.service.WebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SocketMessageDelegate
 *
 * @author elvea
 */
@Slf4j
@Component
public class SocketMessageDelegate implements MessageDelegate<SocketMessage> {

    @Autowired
    WebSocketService webSocketService;

    @Override
    public void handleMessage(SocketMessage message) {
        log.debug("handle message...");
        webSocketService.sendMessage(message);
    }

}
