package org.youcode.EventLinkerAPI.message;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.youcode.EventLinkerAPI.DM.DM;
import org.youcode.EventLinkerAPI.shared.utils.BaseEntity;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message extends BaseEntity {
    private String content ;
    private LocalDateTime sentAt;

    @ManyToOne
    @JoinColumn(name = "DM_ID")
    private DM dm;
}
