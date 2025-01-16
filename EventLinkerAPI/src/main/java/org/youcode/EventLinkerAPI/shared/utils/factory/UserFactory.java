package org.youcode.EventLinkerAPI.shared.utils.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.organizer.DTOs.OrganizerRegistrationDTO;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.BaseRegistrationDTO;
import org.youcode.EventLinkerAPI.user.User;
import org.youcode.EventLinkerAPI.user.mapper.UserMapper;
import org.youcode.EventLinkerAPI.worker.DTOs.WorkerRegistrationDTO;

@Data
@AllArgsConstructor
@Component
public class UserFactory {
    private final UserMapper userMapper;

    public User createUser(String userType , BaseRegistrationDTO dto){
        switch (userType){
            case "WORKER" :
                WorkerRegistrationDTO workerDTO = (WorkerRegistrationDTO) dto;
                return userMapper.toEntity(workerDTO);
            case "Organizer" :
                OrganizerRegistrationDTO organizerDTO = (OrganizerRegistrationDTO) dto;
                return userMapper.toEntity(organizerDTO);
            default:
                throw new IllegalArgumentException("Invalid User Type !");
         }
    }
}
