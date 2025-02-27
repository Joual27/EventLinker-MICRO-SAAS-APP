package org.youcode.EventLinkerAPI.DM;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.youcode.EventLinkerAPI.message.Message;
import org.youcode.EventLinkerAPI.shared.utils.BaseEntity;
import org.youcode.EventLinkerAPI.user.User;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DM extends BaseEntity {
    @OneToMany(mappedBy = "dm")
    private List<Message> messages;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dm_participants",
            joinColumns = @JoinColumn(name = "dm_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;
}
