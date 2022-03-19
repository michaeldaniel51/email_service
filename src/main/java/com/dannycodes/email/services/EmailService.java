package com.dannycodes.email.services;

import com.dannycodes.email.entities.Email;
import com.dannycodes.email.repositories.EmailRepository;
import com.dannycodes.email.vo.Message;
import com.dannycodes.email.vo.ResponseVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final Log log = LogFactory.getLog(this.getClass());

    public String createEmail(Email email){

        email.setDepartment(email.theDepartment());
        email.setPassword(email.password());
        email.setEmail(email.showInfo());
         emailRepository.save(email);
        log.info(email.password());
        return "your registered email is: " + email.showInfo();
   }

    public List<Email> getEmails(){
        return emailRepository.findAll();
    }

    public Email getById(int id){
        return emailRepository.findById(id).get();
    }



    public ResponseVo getMessage(int emailId){
        ResponseVo vo = new ResponseVo();
        Email mail = emailRepository.findByEmailId(emailId);
        Message message = restTemplate.getForObject("http://localhost:8070/message/v1/" + mail.getMessageId(),Message.class);
        vo.setEmail(mail);
        vo.setMessage(message);
        return vo;
    }

    public ResponseVo getByEmail(String email){
        ResponseVo vo = new ResponseVo();
        Email mail = emailRepository.findByEmail(email);
        Message message = restTemplate.getForObject("http://localhost:8070/message/" + mail.getEmail(),Message.class);
        vo.setEmail(mail);
        vo.setMessage(message);
        return vo;
    }


}
