package org.youcode.EventLinkerAPI.user.interfaces;

import org.youcode.EventLinkerAPI.shared.utils.interfaces.BaseRegistrationDTO;
import org.youcode.EventLinkerAPI.user.DTOs.UserResponseDTO;

public interface AuthService {
    UserResponseDTO createUser(String userType , BaseRegistrationDTO data);
}
