package org.youcode.EventLinkerAPI.message.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.DM.DM;
import org.youcode.EventLinkerAPI.message.DTOs.MessageResponseDTO;
import org.youcode.EventLinkerAPI.message.DTOs.SendMessageDTO;
import org.youcode.EventLinkerAPI.message.Message;
import org.youcode.EventLinkerAPI.user.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message toEntity(SendMessageDTO createDTO) {
        if ( createDTO == null ) {
            return null;
        }

        Message message = new Message();

        message.setContent( createDTO.content() );

        return message;
    }

    @Override
    public MessageResponseDTO toResponseDTO(Message message) {
        if ( message == null ) {
            return null;
        }

        Long dmId = null;
        Long userId = null;
        String username = null;
        Long id = null;
        LocalDateTime sentAt = null;
        boolean delivered = false;
        LocalDateTime deliveredAt = null;
        LocalDateTime seenAt = null;
        String content = null;

        dmId = messageDmId( message );
        userId = messageUserId( message );
        username = messageUserUsername( message );
        id = message.getId();
        sentAt = message.getSentAt();
        delivered = message.isDelivered();
        deliveredAt = message.getDeliveredAt();
        seenAt = message.getSeenAt();
        content = message.getContent();

        MessageResponseDTO messageResponseDTO = new MessageResponseDTO( id, sentAt, delivered, deliveredAt, seenAt, content, dmId, userId, username );

        return messageResponseDTO;
    }

    private Long messageDmId(Message message) {
        DM dm = message.getDm();
        if ( dm == null ) {
            return null;
        }
        return dm.getId();
    }

    private Long messageUserId(Message message) {
        User user = message.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    private String messageUserUsername(Message message) {
        User user = message.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getUsername();
    }
}
