package com.lms.springbootbackend.service;

import com.lms.springbootbackend.model.Role;

public  interface RoleService {

    public Role saveRole (Role role);

    public Role findRole (int roleId);
}
