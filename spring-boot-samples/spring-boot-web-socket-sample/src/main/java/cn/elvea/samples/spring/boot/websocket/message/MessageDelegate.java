package cn.elvea.samples.spring.boot.websocket.message;

/**
 * MessageDelegate
 *
 * @author elvea
 */
public interface MessageDelegate<T> {

    void handleMessage(T message);

}
