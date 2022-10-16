package com.lms.springbootbackend.service;

import com.lms.springbootbackend.model.Privilege;

import java.util.List;

public interface PrivilegeService {

    public Privilege savePrivilege(Privilege privilege);

    public List<Privilege> findPrivileges();

    Boolean isPermissionsExists(Integer[] permissions);
}
