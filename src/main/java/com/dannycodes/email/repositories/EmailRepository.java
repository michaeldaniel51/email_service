package com.dannycodes.email.repositories;

import com.dannycodes.email.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email,Integer> {


    Email findByEmail(String email);

    Email findByEmailId(int emailId);
}
