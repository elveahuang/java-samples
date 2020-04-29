package cn.elvea.samples.spring.boot.websocket.config;

import cn.elvea.samples.spring.boot.websocket.handler.DefaultHandler;
import cn.elvea.samples.spring.boot.websocket.interceptor.DefaultHandshakeInterceptor;
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

    private final DefaultHandler defaultHandler;

    private final DefaultHandshakeInterceptor handshakeInterceptor;

    public WebSocketConfig(DefaultHandler defaultHandler, DefaultHandshakeInterceptor handshakeInterceptor) {
        this.defaultHandler = defaultHandler;
        this.handshakeInterceptor = handshakeInterceptor;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(this.defaultHandler, "/text")
                .setAllowedOrigins("*")
                .addInterceptors(this.handshakeInterceptor)
                .withSockJS();
    }

}
