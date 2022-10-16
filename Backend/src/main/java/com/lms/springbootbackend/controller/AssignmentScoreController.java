package com.lms.springbootbackend.controller;

import com.lms.springbootbackend.repo.AssignmentScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lms.springbootbackend.model.AssignmentScore;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AssignmentScoreController {

    @Autowired
    private AssignmentScoreRepo assignmentScoreRepo;

    @GetMapping("/assignment_score/{student_id}")
    public ResponseEntity<List<AssignmentScore>> getAllCourses(@PathVariable("student_id") Long student_id) {
        List<AssignmentScore> assignmentScores = new ArrayList<>();

        assignmentScores = assignmentScoreRepo.findBySchoolStudentStudentId(student_id);

        if (assignmentScores.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(assignmentScores, HttpStatus.OK);


    }
}
