package com.lms.springbootbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.springbootbackend.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
