package org.youcode.EventLinkerAPI.message;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.youcode.EventLinkerAPI.message.DTOs.MessageResponseDTO;
import org.youcode.EventLinkerAPI.shared.utils.DTOs.SuccessDTO;

import java.util.List;


@RequestMapping("/ws/messages")
@AllArgsConstructor
@Controller
public class MessageController {

    @GetMapping("/dms/{dmId}/undelivered")
    public ResponseEntity<SuccessDTO<List<MessageResponseDTO>>> getDmUndeliveredMessages(@PathVariable("dmId") Long dmId ){

    }
}
