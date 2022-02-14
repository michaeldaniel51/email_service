package com.dannycodes.email.controllers;

import com.dannycodes.email.entities.Email;
import com.dannycodes.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String saveEmail(@RequestBody Email email){
      return  emailService.createEmail(email);
    }


    @GetMapping
    public List<Email> getEmail(){
        return emailService.getEmails();
    }

}
