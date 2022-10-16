package com.lms.springbootbackend.service;

import com.lms.springbootbackend.model.Privilege;
import com.lms.springbootbackend.repo.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class PrivilegeServiceImp implements PrivilegeService {

    @Autowired
    PrivilegeRepository privRepo;

    @Autowired
    private EntityManager entityManager;

    public Privilege savePrivilege(Privilege privilege){
        return privRepo.save(privilege);
    }

    public List<Privilege> findPrivileges(){
        return privRepo.findAll();
    }

    public Boolean isPermissionsExists(Integer[] permissions){
        Privilege privileges=null;
        for(int i=0; i<permissions.length; i++){
            privileges = entityManager.find(Privilege.class, permissions[i]);
            if(privileges==null){
                return false;
            }
        }
        return true;
    }
}
