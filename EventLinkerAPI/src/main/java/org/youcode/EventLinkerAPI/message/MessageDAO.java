package org.youcode.EventLinkerAPI.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.EventLinkerAPI.DM.DM;
import org.youcode.EventLinkerAPI.user.User;

import java.util.List;

@Repository
public interface MessageDAO extends JpaRepository<Message , Long> {

    List<Message> findByDmAndDeliveredFalseAndUserNot(DM dm, User user);
}
