package com.lms.springbootbackend.service;

import com.lms.springbootbackend.model.Role;
import com.lms.springbootbackend.model.User;
import com.lms.springbootbackend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleService roleSev;

    @Autowired
    PrivilegeService privRepo;

    @Autowired
    private EntityManager entityManager;

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public boolean findUserByUsername(String username){
        if(userRepo.findByUsername(username).isEmpty() ==  true){
            // username not found
            return false;
        }
        else {
            // username found
            return true;
        }
    }

    public Boolean isRoleExists(int roleId){
        Role roles = entityManager.find(Role.class, roleId);

        if(roles != null){
            return true;
        }
        else{
            return false;
        }
    }


    public void addUserRoles(int roleId){

    }
}
