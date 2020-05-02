package cn.elvea.samples.spring.boot.websocket.service;

import cn.elvea.samples.spring.boot.websocket.vo.WsSessionData;
import org.springframework.web.socket.WebSocketSession;

import java.util.Collection;
import java.util.Map;

/**
 * WebSocketService
 *
 * @author elvea
 */
public interface WebSocketSessionService {

    String ORG_ID_KEY = "WebSocketService.ORG_ID_KEY";
    String USER_SESSION_ID_KEY = "WebSocketService.USER_SESSION_ID_KEY";
    String USER_ID_KEY = "WebSocketService.USER_ID_KEY";
    String USER_USERNAME_KEY = "WebSocketService.USER_USERNAME_KEY";
    String USER_NICKNAME_KEY = "WebSocketService.USER_NICKNAME_KEY";

    /**
     * 创建会话
     *
     * @param userSessionId    用户会话ID
     * @param webSocketSession {@link WebSocketSession}
     */
    void createWsSession(String userSessionId, WebSocketSession webSocketSession);

    /**
     * 结束会话
     *
     * @param userSessionId      用户会话ID
     * @param webSocketSessionId 会话ID
     */
    void closeWsSession(String userSessionId, String webSocketSessionId);

    /**
     * 获取会话
     *
     * @param userSessionId 用户会话ID
     * @return 返回当前用户登录会话所有的WebSocket会话记录
     */
    Map<String, WsSessionData> getWsSessionByUserSessionId(String userSessionId);

    /**
     * 获取所有用户会话
     *
     * @return 返回所有用户会话
     */
    Collection<Map<String, WsSessionData>> getWsSessions();

}
