package com.dannycodes.email.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response <T> {


    private int status;
    private String message;
    private T body;




    public Response <T> response(int status , T body){

        Response<T> re = new Response<T>();

        re.setStatus(status);
        re.setBody(body);
        re.setMessage("SUCCESSFUL");
        return re;

    }












}
