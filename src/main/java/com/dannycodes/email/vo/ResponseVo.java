package com.dannycodes.email.vo;


import com.dannycodes.email.entities.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo {

    private Email email;
    private Message message;




}
