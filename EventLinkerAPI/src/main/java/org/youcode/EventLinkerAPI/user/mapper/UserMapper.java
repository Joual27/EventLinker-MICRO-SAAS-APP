package org.youcode.EventLinkerAPI.user.mapper;

import org.mapstruct.Mapper;
import org.youcode.EventLinkerAPI.organizer.DTOs.OrganizerRegistrationDTO;
import org.youcode.EventLinkerAPI.organizer.Organizer;
import org.youcode.EventLinkerAPI.worker.DTOs.WorkerRegistrationDTO;
import org.youcode.EventLinkerAPI.worker.Worker;
import java.time.LocalDateTime;


@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract Organizer toEntity(OrganizerRegistrationDTO dto);
    public abstract Worker toEntity(WorkerRegistrationDTO dto);
    protected LocalDateTime getDate(){
        return LocalDateTime.now();
    }
}
