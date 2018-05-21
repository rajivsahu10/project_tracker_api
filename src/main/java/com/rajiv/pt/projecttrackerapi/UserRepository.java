package com.rajiv.pt.projecttrackerapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajiv.pt.projecttrackerapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
