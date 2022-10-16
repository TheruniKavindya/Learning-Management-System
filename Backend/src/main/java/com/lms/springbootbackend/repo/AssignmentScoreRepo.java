package com.lms.springbootbackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.springbootbackend.model.AssignmentScore;

public interface AssignmentScoreRepo extends JpaRepository<AssignmentScore, Long>{

    //  find scores by assignmentId
    List<AssignmentScore> findByAssignmentAssignmentId(Long assignmentId);
    //  List<AssignmentScore> findBySchoolStudent_id(Long student_id);
//  find by schoolStudent_id and
    List<AssignmentScore> findBySchoolStudentStudentId(Long studentId);

}
