package cn.elvea.samples.spring.boot.websocket.service;

import cn.elvea.samples.spring.boot.websocket.message.SocketMessage;

/**
 * WebSocketService
 *
 * @author elvea
 */
public interface WebSocketService {

    void sendMessage();

    void sendMessage(SocketMessage socketMessage);

}
