package cn.elvea.samples.spring.boot.websocket.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Message
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class Message {
    private String text;
}
