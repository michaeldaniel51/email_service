package com.dannycodes.email.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response <T> {


    private int status;
    private String message;
    private T body;














}
