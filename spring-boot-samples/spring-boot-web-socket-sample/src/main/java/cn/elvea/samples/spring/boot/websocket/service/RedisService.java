package cn.elvea.samples.spring.boot.websocket.service;

import cn.elvea.samples.spring.boot.websocket.message.SocketMessage;

/**
 * RedisService
 *
 * @author elvea
 */
public interface RedisService {

    String WEB_SOCKET_TOPIC = "Web_Socket_Topic";

    void sendMessage(SocketMessage socketMessage);

}
