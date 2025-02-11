package org.youcode.EventLinkerAPI.auth.refreshToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.auth.refreshToken.interfaces.RefreshTokenService;
import org.youcode.EventLinkerAPI.user.UserDAO;


@AllArgsConstructor
@Service
public class RefreshTokenServiceImp implements RefreshTokenService {
    private final RefreshTokenDAO refreshTokenDAO;
    private final UserDAO userDAO;

    @Override
    public RefreshToken createRefreshToken(String email) {
        return null;
    }

    @Override
    public RefreshToken findByToken(String token) {
        return null;
    }

    @Override
    public boolean isTokenExpired(RefreshToken token) {
        return false;
    }
}
