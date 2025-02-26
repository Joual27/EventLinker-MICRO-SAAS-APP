package org.youcode.EventLinkerAPI.DM;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DMDAO extends JpaRepository<DM , Long> {
}
