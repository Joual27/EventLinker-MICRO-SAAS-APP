package org.youcode.EventLinkerAPI.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.EventLinkerAPI.organizer.DTOs.OrganizerRegistrationDTO;
import org.youcode.EventLinkerAPI.organizer.Organizer;
import org.youcode.EventLinkerAPI.worker.DTOs.WorkerRegistrationDTO;
import org.youcode.EventLinkerAPI.worker.Worker;
import java.time.LocalDateTime;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "createdAt" , expression = "java(LocalDateTime.now())")
    Organizer toEntity(OrganizerRegistrationDTO dto);

    @Mapping(target = "createdAt" , expression = "java(LocalDateTime.now())")
    Worker toEntity(WorkerRegistrationDTO dto);

}
