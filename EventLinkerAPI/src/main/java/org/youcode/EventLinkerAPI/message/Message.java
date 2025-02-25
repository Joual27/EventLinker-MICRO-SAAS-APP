package org.youcode.EventLinkerAPI.message;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.youcode.EventLinkerAPI.DM.DM;
import org.youcode.EventLinkerAPI.message.embeddabales.MessageKey;
import org.youcode.EventLinkerAPI.user.User;

import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    @EmbeddedId
    private MessageKey id;

    @ManyToOne
    @MapsId("dmId")
    @JoinColumn(name = "DM_ID")
    private DM dm;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "USER_ID")
    private User user;

    private LocalDateTime sentAt;
    private boolean delivered;
    private LocalDateTime deliveredAt;
    private LocalDateTime seenAt;
    private String content ;
}
