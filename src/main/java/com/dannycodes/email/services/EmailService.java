package com.dannycodes.email.services;

import com.dannycodes.email.entities.Email;
import com.dannycodes.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;


    public String createEmail(Email email){

        email.setDepartment(email.theDepartment());
        email.setPassword(email.randomPassword(10));
        email.setEmail(email.showInfo());
         emailRepository.save(email);
         return email.showInfo();
    }

    public List<Email> getEmails(){
        return emailRepository.findAll();
    }


}
