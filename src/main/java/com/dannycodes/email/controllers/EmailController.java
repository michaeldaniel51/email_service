package com.dannycodes.email.controllers;

import com.dannycodes.email.entities.Email;
import com.dannycodes.email.response.Response;
import com.dannycodes.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;


    /*
    when creating an email
    input only your firstname and lastname
    and the rest is generated for you automatically
     */

//    @PostMapping
//    public String createEmail(@RequestBody Email email){
//      return  emailService.createEmail(email);
//    }


    @PostMapping
    public Response<?> cr (@RequestBody Email email){

        return Response.builder()
                .status(200)
                .message("ok")
                .body(emailService.createEmail(email))
                .build();

    }


    @GetMapping
    public List<Email> getEmail(){
        return emailService.getEmails();
    }

}
