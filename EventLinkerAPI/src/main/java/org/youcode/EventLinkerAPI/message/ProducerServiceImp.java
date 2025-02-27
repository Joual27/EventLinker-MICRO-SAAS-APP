package org.youcode.EventLinkerAPI.message;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.DM.DM;
import org.youcode.EventLinkerAPI.DM.interfaces.DMService;
import org.youcode.EventLinkerAPI.message.DTOs.MessageResponseDTO;
import org.youcode.EventLinkerAPI.message.DTOs.SendMessageDTO;
import org.youcode.EventLinkerAPI.message.interfaces.ProducerService;
import org.youcode.EventLinkerAPI.message.mapper.MessageMapper;
import org.youcode.EventLinkerAPI.user.User;

import java.security.Principal;
import java.time.LocalDateTime;


@AllArgsConstructor
@Service
public class ProducerServiceImp implements ProducerService {

    private final MessageDAO messageDAO;
    private final DMService dmService;
    private final MessageMapper messageMapper;
    private final KafkaTemplate<String , Message> kafkaTemplate;

    @Override
    public MessageResponseDTO sendMessage(SendMessageDTO data , Principal principal) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) principal;
        User user = (User) usernamePasswordAuthenticationToken.getPrincipal();
        DM existingDm = dmService.getDMEntityById(data.dmId());
        if (!isUserDM(existingDm , user)){
            throw new AccessDeniedException("You 't belong to this DM !");
        }
        Message messageToSend = messageMapper.toEntity(data);
        Message messageWithData = fillMessageDefaultData(messageToSend , user);
        Message createdMessage = messageDAO.save(messageWithData);
        kafkaTemplate.send("direct-messages" , messageToSend.getDm().getId().toString() , createdMessage);
        return messageMapper.toResponseDTO(createdMessage);
    }

    private Message fillMessageDefaultData(Message message , User user){
        message.setSentAt(LocalDateTime.now());
        message.setUser(user);
        message.setDelivered(false);
        return message;
    }

    private boolean isUserDM(DM dm , User user){
        return dm.getUsers().contains(user);
    }
}
