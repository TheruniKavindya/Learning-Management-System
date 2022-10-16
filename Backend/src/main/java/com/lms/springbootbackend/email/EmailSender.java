package com.lms.springbootbackend.email;

public interface EmailSender {
    void send(String to, String email);
}
