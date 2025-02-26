package org.youcode.EventLinkerAPI.message.mapper;


import org.mapstruct.Mapper;
import org.youcode.EventLinkerAPI.message.DTOs.MessageResponseDTO;
import org.youcode.EventLinkerAPI.message.DTOs.SendMessageDTO;
import org.youcode.EventLinkerAPI.message.Message;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.mappers.BaseCreateMapper;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.mappers.BaseResponseMapper;

@Mapper(componentModel = "spring")
public interface MessageMapper extends BaseCreateMapper<Message , SendMessageDTO> , BaseResponseMapper<Message , MessageResponseDTO> {
}
