package com.lms.springbootbackend.repo;

import com.lms.springbootbackend.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>  {
}
