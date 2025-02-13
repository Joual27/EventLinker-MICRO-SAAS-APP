package org.youcode.EventLinkerAPI.event.DTOs;


import java.time.LocalDateTime;

public record EventResponseDTO(Long id , String description ,  LocalDateTime date , String location) {
}
