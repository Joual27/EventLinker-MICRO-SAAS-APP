package org.youcode.EventLinkerAPI.user;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.shared.utils.factory.UserFactory;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.BaseRegistrationDTO;
import org.youcode.EventLinkerAPI.shared.utils.security.JwtService;
import org.youcode.EventLinkerAPI.user.DTOs.LoginDTO;
import org.youcode.EventLinkerAPI.user.DTOs.AuthResponseDTO;
import org.youcode.EventLinkerAPI.user.interfaces.AuthService;

@AllArgsConstructor
@Service
public class AuthServiceImp implements AuthService {
    private final UserDAO userDAO;
    private final UserFactory userFactory;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDTO createUser(String userType , BaseRegistrationDTO data) {
        User userToCreate = userFactory.createUser(userType , data);
        userToCreate.setPassword(passwordEncoder.encode(userToCreate.getPassword()));
        User createdUser = userDAO.save(userToCreate);
        String token = jwtService.generateToken(createdUser);
        Authentication auth = new UsernamePasswordAuthenticationToken(
                createdUser,
                null,
                createdUser.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        return new AuthResponseDTO(createdUser.getId() , token , createdUser.getUserRole());
    }

    @Override
    public AuthResponseDTO authenticate(LoginDTO credentials) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(credentials.email() , credentials.password());
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtService.generateToken(auth);
        User signedInUser = (User) auth.getPrincipal();
        return new AuthResponseDTO(signedInUser.getId() , token , signedInUser.getUserRole());
    }
}
