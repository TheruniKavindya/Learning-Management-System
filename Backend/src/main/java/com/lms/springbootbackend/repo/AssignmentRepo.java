package com.lms.springbootbackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.springbootbackend.model.Assignments;

public interface AssignmentRepo extends JpaRepository<Assignments, Long>{

    //find the submissions of a assignment

    Assignments findByAssTitle(String title);
    List<Assignments> findByCourseCourseId(Long course_id);

}
