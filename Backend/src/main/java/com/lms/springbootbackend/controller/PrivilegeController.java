package com.lms.springbootbackend.controller;

import com.lms.springbootbackend.model.Privilege;
import com.lms.springbootbackend.service.PrivilegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privSev;

    Logger logger = LoggerFactory.getLogger(PrivilegeController.class);

    @PostMapping("/user/privileges/new")
    public ResponseEntity<Privilege> createPrivilege(@RequestBody Privilege privilege){
        try{
            logger.info("Successfully saved a new privilege");
            return new ResponseEntity<>(privSev.savePrivilege(privilege), HttpStatus.CREATED);
        }
        catch (Exception e){
            logger.error("Error occurred");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
