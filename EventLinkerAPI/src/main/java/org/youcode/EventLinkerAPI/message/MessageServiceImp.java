package org.youcode.EventLinkerAPI.message;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.DM.DM;
import org.youcode.EventLinkerAPI.DM.interfaces.DMService;
import org.youcode.EventLinkerAPI.message.DTOs.MessageResponseDTO;
import org.youcode.EventLinkerAPI.message.interfaces.MessageService;
import org.youcode.EventLinkerAPI.message.mapper.MessageMapper;
import org.youcode.EventLinkerAPI.user.User;

import java.util.List;

@AllArgsConstructor
@Service
public class MessageServiceImp implements MessageService {

    private final DMService dmService;
    private final MessageDAO messageDAO;
    private final MessageMapper messageMapper;

    @Override
    public List<MessageResponseDTO> getDmUndeliveredMessages(Long dmId){
        DM existingDm = dmService.getDMEntityById(dmId);
        User authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Message> undeliveredMessages = messageDAO.findByDmAndDeliveredFalseAndUserNot(existingDm, authenticatedUser);
        return undeliveredMessages.stream().map(messageMapper::toResponseDTO).toList();
    }
}
