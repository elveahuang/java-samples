package cn.elvea.samples.spring.boot.websocket.config;

import cn.elvea.samples.spring.boot.websocket.handler.MessageWebSocketHandler;
import cn.elvea.samples.spring.boot.websocket.interceptor.SessionHandshakeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * WebSocketConfig
 *
 * @author elvea
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final MessageWebSocketHandler messageWebSocketHandler;

    private final SessionHandshakeInterceptor handshakeInterceptor;

    public WebSocketConfig(MessageWebSocketHandler messageWebSocketHandler,
                           SessionHandshakeInterceptor handshakeInterceptor) {
        this.messageWebSocketHandler = messageWebSocketHandler;
        this.handshakeInterceptor = handshakeInterceptor;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(this.messageWebSocketHandler, "/socket")
                .setAllowedOrigins("*")
                .addInterceptors(this.handshakeInterceptor);

        registry.addHandler(this.messageWebSocketHandler, "/socket/sock-js")
                .setAllowedOrigins("*")
                .addInterceptors(this.handshakeInterceptor)
                .withSockJS();
    }

}
