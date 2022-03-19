package com.dannycodes.email.controllers;

import com.dannycodes.email.entities.Email;
import com.dannycodes.email.response.Response;
import com.dannycodes.email.services.EmailService;
import com.dannycodes.email.vo.ResponseVo;
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

//        return new Response<>()
//                .response(200,emailService.createEmail(email));


        return Response.builder()
                .status(200)
                .message("ok")
                .body(emailService.createEmail(email))
                .build();

    }

//    @GetMapping("/v1/{email}")
//    public Email getByEmail(@PathVariable String email){
//        return emailService.findByEmail(email);
//    }

    @GetMapping("id/{id}")
    public Email getById(@PathVariable int id){
        return emailService.getById(id);
    }

    @GetMapping("/v1/{emailId}")
    public ResponseVo getEmailMessage(@PathVariable int emailId){
        return emailService.getMessage(emailId);
    }

    @GetMapping("/{email}")
    public ResponseVo getByEmail(@PathVariable String email){
        return emailService.getByEmail(email);
    }

    @GetMapping
    public List<Email> getEmail(){
        return emailService.getEmails();
    }

}
