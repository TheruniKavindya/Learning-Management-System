package com.lms.springbootbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.springbootbackend.model.Assignments;
import com.lms.springbootbackend.model.Student;
import com.lms.springbootbackend.model.Submission;

import java.util.List;


public interface SubmissionRepo extends JpaRepository<Submission, Long>{

    List<Submission> findByStudent(Student student);
    List<Submission> findByAssignment(Assignments assignment);
    List<Submission> findByAssignmentAndStudent(Assignments assignment, Student student);
}
