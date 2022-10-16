package com.lms.springbootbackend.controller;

import com.lms.springbootbackend.repo.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.lms.springbootbackend.model.Assignments;

public class AssignmentsController {

    @Autowired
    private AssignmentRepo assignmentRepo;

    @GetMapping("/assignments/{course_id}")
    public ResponseEntity<List<Assignments>> getAllAssignmentsByCourseId(@PathVariable("course_id") Long course_id) {

        List<Assignments> assignments = new ArrayList<>(assignmentRepo.findByCourseCourseId(course_id));

        if (assignments.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(assignments, HttpStatus.OK);

    }

    //  create an assignment
    @PostMapping("/create_assignment")
    public ResponseEntity<Assignments> createAssignment(@RequestBody Assignments assignment) {
        try{
            assignmentRepo.save(assignment);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(assignment, HttpStatus.CREATED);
    }

    //update an assignment
    @PutMapping("/assignments/{id}")
    public ResponseEntity<Assignments> updateAssignment(@PathVariable("id") Long id, @RequestBody Assignments assignment) {
        Optional<Assignments> assignmentData = assignmentRepo.findById(id);
        if (assignmentData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Assignments assignment_2 = assignmentData.get();

        Date dueDate = assignment.getAssignmentDueDate();
        String title = assignment.getAssTitle();
        String description = assignment.getDescription();

        if (dueDate != null) {
            assignment_2.setAssignmentDueDate(dueDate);
        }
        if (title != null) {
            assignment_2.setAssTitle(title);
        }
        if (description != null) {
            assignment_2.setDescription(description);
        }

//    put to db
        try{
            assignmentRepo.save(assignment_2);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(assignment_2, HttpStatus.OK);

    }

}
