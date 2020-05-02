package cn.elvea.samples.spring.boot.websocket.service.impl;

import cn.elvea.samples.spring.boot.websocket.service.WebSocketSessionService;
import cn.elvea.samples.spring.boot.websocket.vo.WsSessionData;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocketServiceImpl
 *
 * @author elvea
 * @see WebSocketSessionService
 */
@Slf4j
@Service
public class WebSocketSessionServiceImpl implements WebSocketSessionService {

    public final static String WEB_SOCKET_SESSION_CACHE = "WEB_SOCKET_SESSION_CACHE";

    @Autowired
    private RedissonClient redissonClient;

    /**
     * @see WebSocketSessionService#createWsSession(String, WebSocketSession)
     */
    @Override
    public void createWsSession(String userSessionId, WebSocketSession wsSession) {
        RMap<String, Map<String, WsSessionData>> sessionMap = getSessionMap();

        RLock lock = sessionMap.getLock(userSessionId);
        try {
            lock.lock();

            Map<String, WsSessionData> sessions = sessionMap.getOrDefault(userSessionId, new ConcurrentHashMap<>());
            sessions.put(wsSession.getId(), new WsSessionData(wsSession.getId()));
            sessionMap.putIfAbsent(userSessionId, sessions);
        } finally {
            lock.unlock();
        }
    }

    /**
     * @see WebSocketSessionService#closeWsSession(String, String)
     */
    @Override
    public void closeWsSession(String userSessionId, String webSocketSessionId) {
        RMap<String, Map<String, WsSessionData>> sessionMap = getSessionMap();

        RLock lock = sessionMap.getLock(userSessionId);
        try {
            lock.lock();

            Map<String, WsSessionData> sessions = sessionMap.getOrDefault(userSessionId, new ConcurrentHashMap<>());
            if (sessions != null) {
                boolean result = sessions.remove(webSocketSessionId) != null;
                if (log.isDebugEnabled()) {
                    log.debug("close socket session [{}] of user session [{}] was {}", webSocketSessionId, userSessionId, result);
                }
                if (sessions.isEmpty()) {
                    sessionMap.remove(userSessionId);
                } else {
                    sessionMap.putIfAbsent(userSessionId, sessions);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * @see WebSocketSessionService#getWsSessionByUserSessionId(String)
     */
    @Override
    public Map<String, WsSessionData> getWsSessionByUserSessionId(String userSessionId) {
        return getSessionMap().get(userSessionId);
    }

    /**
     * @see WebSocketSessionService#getWsSessions()
     */
    @Override
    public Collection<Map<String, WsSessionData>> getWsSessions() {
        return getSessionMap().values();
    }

    /**
     * 获取Redis缓存的会话记录
     *
     * @return {@link RMap}
     */
    private RMap<String, Map<String, WsSessionData>> getSessionMap() {
        return this.redissonClient.getMap(WEB_SOCKET_SESSION_CACHE);
    }

}
