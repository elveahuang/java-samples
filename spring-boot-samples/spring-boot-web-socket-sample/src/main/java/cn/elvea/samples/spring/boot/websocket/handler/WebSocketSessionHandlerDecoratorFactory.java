package cn.elvea.samples.spring.boot.websocket.handler;

import cn.elvea.samples.spring.boot.websocket.service.WebSocketSessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

/**
 * WebSocketSessionHandlerDecoratorFactory
 *
 * @author dfox
 */
@Slf4j
@Component
public class WebSocketSessionHandlerDecoratorFactory implements WebSocketHandlerDecoratorFactory {

    @Autowired
    private WebSocketSessionService webSocketSessionService;

    @Override
    public WebSocketHandler decorate(WebSocketHandler handler) {
        return new WebSocketHandlerDecorator(handler) {
            @Override
            public void afterConnectionEstablished(WebSocketSession wsSession) throws Exception {
                if (log.isDebugEnabled()) {
                    log.debug("create socket session [{}].", wsSession.getId());
                }
                webSocketSessionService.createWsSession(wsSession.getId(), wsSession);
                super.afterConnectionEstablished(wsSession);
            }

            @Override
            public void afterConnectionClosed(WebSocketSession wsSession, CloseStatus status) throws Exception {
                if (log.isDebugEnabled()) {
                    log.debug("close socket session [{}].", wsSession.getId());
                }
                webSocketSessionService.closeWsSession(wsSession.getId(), wsSession.getId());
                super.afterConnectionClosed(wsSession, status);
            }
        };
    }

}
