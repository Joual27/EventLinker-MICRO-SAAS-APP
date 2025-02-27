package org.youcode.EventLinkerAPI.message;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.DM.DM;
import org.youcode.EventLinkerAPI.exceptions.EntityNotFoundException;
import org.youcode.EventLinkerAPI.message.interfaces.ConsumerService;
import org.youcode.EventLinkerAPI.user.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ConsumerServiceImp implements ConsumerService {
    private final SimpMessagingTemplate messagingTemplate;
    private final RedisTemplate<String , String> redisTemplate;
    private final MessageDAO messageDAO;

    @KafkaListener(topics = "direct-messages" , groupId = "message-group")
    @Override
    public void processMessage(Message message) {
        User recipient = getMessageRecipient(message);
        if (recipientIsOnline(recipient.getId())){
            sendThroughSockets(message , message.getDm());
            markAsDelivered(message);
        }
    }

    private User getMessageRecipient(Message message){
        return message.getDm().getUsers().stream()
                .filter(user -> !user.getId().equals(message.getUser().getId()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("GIVEN USER ID DOESNT BELONG TO THIS DM !"));
    }

    private void sendThroughSockets(Message message , DM dm){
        String destination = "/topic/dm/" + dm.getId();
        messagingTemplate.convertAndSend(destination , message);
    }

    private boolean recipientIsOnline(Long recipientId){
        return Boolean.TRUE.equals(
                redisTemplate.hasKey("user:" + recipientId + ":sessions")
        );
    }

    private Message markAsDelivered(Message message){
        message.setDelivered(true);
        message.setDeliveredAt(LocalDateTime.now());
        return messageDAO.save(message);
    }



}

