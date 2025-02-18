package org.youcode.EventLinkerAPI.worker;

import jakarta.persistence.*;
import lombok.*;
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
    @OneToMany(mappedBy = "applicant" , fetch = FetchType.EAGER , orphanRemoval = true)
    private List<Application> applications;

    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinTable(
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "SKILL_ID")
    )
    @ToString.Exclude
    private List<Skill> skills;

    @Override
    protected String getUserRole() {
        return "WORKER";
    }
}
