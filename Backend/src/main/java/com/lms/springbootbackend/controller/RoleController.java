package com.lms.springbootbackend.controller;

import com.lms.springbootbackend.controller.dto.RoleDTO;
import com.lms.springbootbackend.model.Privilege;
import com.lms.springbootbackend.model.Role;
import com.lms.springbootbackend.service.PrivilegeService;
import com.lms.springbootbackend.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;

@Controller
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleSev;

    @Autowired
    private PrivilegeService priSev;

    @Autowired
    private EntityManager entityManager;

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @PostMapping("/user/roles/new")
    public ResponseEntity<Role> createRole(@RequestBody RoleDTO roleDTO){
        try{
            Role newRole = new Role(roleDTO.getRolename(), roleDTO.getStatus());
            if(priSev.isPermissionsExists(roleDTO.getRolePermissios())==true){
                for(int i=0; i<roleDTO.getRolePermissios().length; i++){
                    newRole.addPrivilege(entityManager.find(Privilege.class, roleDTO.getRolePermissios()[i] ));
                }
                logger.info("Successfully saved a new role");
                return new ResponseEntity<>(roleSev.saveRole(newRole), HttpStatus.CREATED);
            }else {
                logger.error("Given privilege(s) not found");
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            logger.error("Error occurred");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
