package cn.elvea.samples.spring.boot.websocket.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * WsSessionData
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class WsSessionData implements Serializable {
    /**
     * 会话ID
     */
    private String wsSessionId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;

    public WsSessionData(String wsSessionId) {
        this.wsSessionId = wsSessionId;
    }

}
