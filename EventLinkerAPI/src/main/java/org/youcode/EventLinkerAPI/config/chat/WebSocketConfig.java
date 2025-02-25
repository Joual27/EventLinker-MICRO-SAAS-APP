package org.youcode.EventLinkerAPI.config.chat;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.youcode.EventLinkerAPI.shared.utils.security.JwtService;

import java.util.Map;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private final String clientUrl;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public WebSocketConfig(@Value("${CLIENT_URL}") String clientUrl , UserDetailsService userDetailsService , JwtService jwtService){
        this.clientUrl = clientUrl;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns(clientUrl)
                .withSockJS()
                .setInterceptors(authenticationInterceptor());
    }

    public HandshakeInterceptor authenticationInterceptor() {
        return new HandshakeInterceptor() {
            @Override
            public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                           WebSocketHandler wsHandler, Map<String, Object> attributes) {
                if (request instanceof ServletServerHttpRequest) {
                    HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
                    String token = servletRequest.getHeader("Authorization");

                    if (token != null && token.startsWith("Bearer ")) {
                        token = token.substring(7);
                        String email = jwtService.extractUsername(token);

                        if (email != null) {
                            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                            if (jwtService.validateToken(token, userDetails)) {
                                attributes.put("user", userDetails);
                                return true;
                            }
                        }
                    }
                    response.setStatusCode(HttpStatus.UNAUTHORIZED);
                    return false;
                }
                return true;
            }
            @Override
            public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                       WebSocketHandler wsHandler, Exception exception) {

            }

        };
    }

}
