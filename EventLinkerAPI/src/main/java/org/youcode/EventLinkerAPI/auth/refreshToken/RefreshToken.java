package org.youcode.EventLinkerAPI.auth.refreshToken;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.youcode.EventLinkerAPI.shared.utils.BaseEntity;
import org.youcode.EventLinkerAPI.user.User;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefreshToken extends BaseEntity {
    @Column(unique = true)
    private String token;
    @ManyToOne()
    private User user;
    private Instant expirationDate;
    private boolean revoked;
}
