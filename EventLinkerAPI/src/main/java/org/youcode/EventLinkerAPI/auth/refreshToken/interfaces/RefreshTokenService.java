package org.youcode.EventLinkerAPI.auth.refreshToken.interfaces;

import org.youcode.EventLinkerAPI.auth.refreshToken.RefreshToken;
import org.youcode.EventLinkerAPI.user.DTOs.AccessTokenResponseDTO;

public interface RefreshTokenService {
    RefreshToken createRefreshToken(String email);
    RefreshToken findByToken(String token);
    boolean isTokenExpired(RefreshToken token);

}
