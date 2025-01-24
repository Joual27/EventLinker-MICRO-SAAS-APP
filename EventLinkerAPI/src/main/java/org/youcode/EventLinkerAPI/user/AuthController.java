package org.youcode.EventLinkerAPI.user;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.EventLinkerAPI.shared.utils.DTOs.SuccessDTO;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.BaseRegistrationDTO;
import org.youcode.EventLinkerAPI.user.DTOs.UserResponseDTO;
import org.youcode.EventLinkerAPI.user.interfaces.AuthService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/public/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register/{userType}")
    public ResponseEntity<SuccessDTO<UserResponseDTO>> register(@PathVariable String userType, @Valid BaseRegistrationDTO req){
        UserResponseDTO res = authService.createUser(userType, req);
        return new ResponseEntity<>(new SuccessDTO<>("Success" , res.role()+ " created Successfully" , res) , HttpStatus.CREATED);
    }
}
