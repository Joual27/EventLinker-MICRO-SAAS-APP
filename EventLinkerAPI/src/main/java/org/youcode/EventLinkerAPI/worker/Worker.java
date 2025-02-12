package org.youcode.EventLinkerAPI.worker;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.youcode.EventLinkerAPI.application.Application;
import org.youcode.EventLinkerAPI.skill.Skill;
import org.youcode.EventLinkerAPI.user.User;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Worker extends User {
    private boolean isOrganization;
    @OneToMany(mappedBy = "applicant" , fetch = FetchType.EAGER)
    private List<Application> applications;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "SKILL_ID")
    )
    private List<Skill> skills;

    @Override
    protected String getUserRole() {
        return "WORKER";
    }
}
