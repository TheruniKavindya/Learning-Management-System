package com.lms.springbootbackend.service;

import com.lms.springbootbackend.model.User;

public interface UserService {

    public User saveUser(User user);

    public boolean findUserByUsername(String username);
}
