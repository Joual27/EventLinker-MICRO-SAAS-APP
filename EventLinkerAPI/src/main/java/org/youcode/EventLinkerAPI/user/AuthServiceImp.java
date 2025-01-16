package org.youcode.EventLinkerAPI.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.shared.utils.factory.UserFactory;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.BaseRegistrationDTO;
import org.youcode.EventLinkerAPI.shared.utils.security.JwtService;
import org.youcode.EventLinkerAPI.user.DTOs.UserResponseDTO;
import org.youcode.EventLinkerAPI.user.interfaces.AuthService;


@AllArgsConstructor
@Service
public class AuthServiceImp implements AuthService {
    private final UserDAO userDAO;
    private final UserFactory userFactory;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public UserResponseDTO createUser(String userType , BaseRegistrationDTO data) {
        User userToCreate = userFactory.createUser(userType , data);
        userToCreate.setPassword(passwordEncoder.encode(userToCreate.getPassword()));
        User createdUser = userDAO.save(userToCreate);
        String token = jwtService.generateToken(createdUser);
        return new UserResponseDTO(createdUser.getId() , token , createdUser.getUserRole());
    }
}
