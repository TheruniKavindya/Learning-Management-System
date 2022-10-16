package com.lms.springbootbackend.repo;

import com.lms.springbootbackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends  JpaRepository<Role,Integer> {
}
