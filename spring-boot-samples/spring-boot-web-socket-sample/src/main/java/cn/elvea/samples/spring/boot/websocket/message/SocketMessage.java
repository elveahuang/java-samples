package cn.elvea.samples.spring.boot.websocket.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * SocketMessage
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class SocketMessage implements Serializable {
    private String message;
}
