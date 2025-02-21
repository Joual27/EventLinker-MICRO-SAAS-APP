package org.youcode.EventLinkerAPI.message.embeddabales;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class MessageKey implements Serializable {
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "DM_ID")
    private Long dmId;

}
