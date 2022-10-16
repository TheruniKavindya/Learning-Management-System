package com.lms.springbootbackend.authentication;

import lombok.Data;

@Data
public class AuthRequest {
    //@Email @Length(min = 10, max = 50)
    private String email;
    //@Length(min = 6, max = 10)
    private String password;

    public AuthRequest(){

    }

    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
