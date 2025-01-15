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

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DM extends BaseEntity {
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "DM_ID"),
            inverseJoinColumns = @JoinColumn(name = "PARTCIPANT_ID")
    )
    private List<User> participants;

    @OneToMany(mappedBy = "dm" , fetch = FetchType.EAGER)
    private List<Message> messages;
}
