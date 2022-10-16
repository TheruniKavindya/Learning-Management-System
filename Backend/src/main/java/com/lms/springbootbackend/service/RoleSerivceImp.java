package com.lms.springbootbackend.service;

import com.lms.springbootbackend.model.Role;
import com.lms.springbootbackend.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleSerivceImp implements RoleService{

    @Autowired
    RoleRepository roleRepo;

    public Role saveRole(Role role){
        return roleRepo.save(role);
    }
//    public Role findRole(int roleId){
//        return roleRepo.findById(roleId);
//    }

    //    public boolean deleteRole(int roleID){
//        return true;
//    }
//
    public  Role findRole(int id){
        return roleRepo.getReferenceById(id);
    }
}
