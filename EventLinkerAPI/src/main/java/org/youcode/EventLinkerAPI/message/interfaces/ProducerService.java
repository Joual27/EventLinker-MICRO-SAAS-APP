package org.youcode.EventLinkerAPI.message.interfaces;

import org.youcode.EventLinkerAPI.message.DTOs.MessageResponseDTO;
import org.youcode.EventLinkerAPI.message.DTOs.SendMessageDTO;

import java.security.Principal;

public interface ProducerService {
    MessageResponseDTO sendMessage(SendMessageDTO data , Principal principal);
}
