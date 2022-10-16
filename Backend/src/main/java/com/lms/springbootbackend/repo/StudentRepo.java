package com.lms.springbootbackend.repo;

import com.lms.springbootbackend.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long>{

    List<Student> findByGradeAndRoll(String grade,int roll);
    List<Student> findBySession(String session);
    List<Student> findByGradeAndShift(String grade, String shift);
    List<Student> findByGrade(String grade);

    Student findByRollAndGrade(int roll, String grade);

}
