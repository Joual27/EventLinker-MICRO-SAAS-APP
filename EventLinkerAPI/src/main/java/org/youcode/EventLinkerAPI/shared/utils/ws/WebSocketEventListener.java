package org.youcode.EventLinkerAPI.shared.utils.ws;


import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.youcode.EventLinkerAPI.user.User;

@AllArgsConstructor
@Component
public class WebSocketEventListener {

    private final WebSocketSessionManager webSocketSessionManager;

    @EventListener
    public void handleConnection(SessionConnectedEvent event){
        User authenticatedUser = (User) event.getUser();
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.wrap(event.getMessage());
        String sessionId = headerAccessor.getSessionId();
        webSocketSessionManager.trackUserSession(authenticatedUser , sessionId);
    }

    @EventListener
    public void handleDisconnection(SessionDisconnectEvent event){
        User authenticatedUser = (User) event.getUser();
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.wrap(event.getMessage());
        String sessionId = headerAccessor.getSessionId();
        webSocketSessionManager.removeUserSession(authenticatedUser ,sessionId);
    }
}
