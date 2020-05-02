package cn.elvea.samples.spring.boot.websocket.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * MessageWebSocketHandler
 *
 * @author elvea
 */
@Slf4j
@Component
public class MessageWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        log.debug(session.getId());
    }

}
