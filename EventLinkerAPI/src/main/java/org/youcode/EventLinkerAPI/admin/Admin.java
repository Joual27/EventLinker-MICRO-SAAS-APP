package org.youcode.EventLinkerAPI.admin;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.youcode.EventLinkerAPI.user.User;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Admin extends User {
    @Override
    protected String getUserRole() {
        return "ADMIN";
    }
}
