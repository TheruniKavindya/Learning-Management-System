package com.lms.springbootbackend.controller;

import com.lms.springbootbackend.controller.dto.UserDTO;
import com.lms.springbootbackend.model.Role;
import com.lms.springbootbackend.model.User;
import com.lms.springbootbackend.repo.UserRepository;
import com.lms.springbootbackend.service.PrivilegeService;
import com.lms.springbootbackend.service.UserService;
import com.lms.springbootbackend.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService useSev;

    @Autowired
    UserRepository uerrepo;

    @Autowired
    PrivilegeService addPrivilege;

    @Autowired
    UserServiceImp userSev;

    @Autowired
    private EntityManager entityManager;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/user/new")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userdetails){
        try{
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String rawPassword = userdetails.getPassword();
            String encodedPassword = passwordEncoder.encode(rawPassword);
            User newUser = new User(userdetails.getEmail(), userdetails.getUsername(), encodedPassword);
            if ( userSev.isRoleExists(userdetails.getRoleId()) == true) {
                // adding user role
                newUser.addRole(entityManager.find(Role.class, userdetails.getRoleId()));
                logger.info("Successfully registered a new user");
                    return new ResponseEntity<>(useSev.saveUser(newUser), HttpStatus.CREATED);
            }
            else {
                logger.error("user role not found");
                    return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }
        catch (NumberFormatException e){
            logger.error("invalid value assignment");
                    return  new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            if(userSev.findUserByUsername(userdetails.getUsername())==true){
                logger.error("Username is already taken");
                    return new ResponseEntity<>(null , HttpStatus.FOUND);
            }else{
                logger.error("Registration was not successful");
                    return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
            }
            // e.printStackTrace();
        }
    }
}
