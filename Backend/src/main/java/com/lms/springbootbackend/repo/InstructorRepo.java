package com.lms.springbootbackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.springbootbackend.model.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Long>{

    List<Instructor> findByDesignation(String designation);

}
