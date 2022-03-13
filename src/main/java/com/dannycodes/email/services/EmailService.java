package com.dannycodes.email.services;

import com.dannycodes.email.entities.Email;
import com.dannycodes.email.repositories.EmailRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    private final Log log = LogFactory.getLog(this.getClass());

    public String createEmail(Email email){

        email.setDepartment(email.theDepartment());
        email.setPassword(email.password());
        email.setEmail(email.showInfo());
         emailRepository.save(email);
        log.info(email.password());
        return "your registered email is: " + email.showInfo();
        // return "your registered email is:\n " + email.showInfo();
    }

    public List<Email> getEmails(){
        return emailRepository.findAll();
    }


}
