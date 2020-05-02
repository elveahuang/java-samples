package cn.elvea.samples.spring.boot.websocket.config;

import cn.elvea.samples.spring.boot.websocket.handler.WebSocketSessionHandlerDecoratorFactory;
import cn.elvea.samples.spring.boot.websocket.interceptor.SessionHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

/**
 * WebSocketMessageBrokerConfig
 *
 * @author elvea
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketMessageBrokerConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private WebSocketSessionHandlerDecoratorFactory webSocketSessionHandlerDecoratorFactory;

    @Autowired
    private SessionHandshakeInterceptor sessionHandshakeInterceptor;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/message");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/web-socket")
                .setAllowedOrigins("*")
                .addInterceptors(this.sessionHandshakeInterceptor);

        registry.addEndpoint("/web-socket/sock-js")
                .setAllowedOrigins("*")
                .addInterceptors(this.sessionHandshakeInterceptor)
                .withSockJS();
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry.addDecoratorFactory(webSocketSessionHandlerDecoratorFactory);
    }

}
