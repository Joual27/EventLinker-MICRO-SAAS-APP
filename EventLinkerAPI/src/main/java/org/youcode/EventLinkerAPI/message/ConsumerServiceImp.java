package org.youcode.EventLinkerAPI.message;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.message.interfaces.ConsumerService;

@AllArgsConstructor
@Service
public class ConsumerServiceImp implements ConsumerService {
    private final SimpMessagingTemplate messagingTemplate;
    private final RedisTemplate<String , String> redisTemplate;
    private final

    @Override
    public void processMessage(Message message) {

    }
}
