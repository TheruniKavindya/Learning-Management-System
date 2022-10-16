package com.lms.springbootbackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lms.springbootbackend.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.springbootbackend.model.Student;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> students = new ArrayList<>(studentRepo.findAll());

        if (students.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    //get students by grade
    @GetMapping("/students_by_grade/{grade}")
    public ResponseEntity<List<Student>> getStudentsByGrade(@PathVariable("grade") String grade) {
        List<Student> students = new ArrayList<>();

        studentRepo.findByGrade(grade).forEach(students::add);

        if (students.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    //Get students by grade and shift

    @GetMapping("/students_by_grade_shift/{grade}/{shift}")
    public ResponseEntity<List<Student>> getStudentsByGradeAndShift(@PathVariable("grade") String grade, @PathVariable("shift") String shift) {
        List<Student> students = new ArrayList<>();
        if (grade == null || shift == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        studentRepo.findByGradeAndShift(grade, shift).forEach(students::add);

        if (students.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(students, HttpStatus.OK);

    }
    //get by id
    @GetMapping("/students_byId/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {

        Optional<Student> studentdata = studentRepo.findById(id);

        return studentdata.map(student -> new ResponseEntity<>(student, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //get by grade,roll
    @GetMapping("/students_by_grade_roll/{grade}/{roll}")
    public ResponseEntity<Student> getStudentByRollAndGrade(@PathVariable("grade") String grade, @PathVariable("roll") int roll){
        Student studentdata = studentRepo.findByRollAndGrade(roll,grade);

        return studentdata != null ? new ResponseEntity<>(studentdata, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Insert a new student to db
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student _student = studentRepo.save(new Student().setRoll(student.getRoll()).setFirstname(student.getFirstname()).
                    setLastname(student.getLastname()).
                    setGrade(student.getGrade())
                    .setShift(student.getShift())
                    .setDateOfBirth(student.getDateOfBirth())
                    .setIs_regular(true)
                    .setSection(student.getSection())

            );
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //update a students email, address, phone, photo_url by roll and grade
    @PutMapping("/students/{grade}/{roll}")
    public ResponseEntity<Student> updateStudentInfo(@PathVariable("grade") String grade, @PathVariable("roll") String roll, @RequestBody Student student) {
        int _roll = Integer.parseInt(roll);
        Student _student = studentRepo.findByRollAndGrade(_roll, grade);
        if (_student != null) {
            String address = student.getAddress();
            String phone = student.getPhone();
            String photo_url = student.getPhoto_url();
            String email = student.getEmail();

            if (address != null)
                _student.setAddress(address);
            if (phone != null)
                _student.setPhone(phone);
            if (photo_url != null)
                _student.setPhoto_url(photo_url);
            if (email != null)
                _student.setEmail(email);
            _student = studentRepo.save(_student);


            return new ResponseEntity<>(_student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete a student by roll and grade
    @DeleteMapping("/students/{grade}/{roll}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("grade") String grade, @PathVariable("roll") String roll) {
        int _roll = Integer.parseInt(roll);
        Student _student = studentRepo.findByRollAndGrade(_roll, grade);
        if (_student != null) {
            studentRepo.delete(_student);
            return new ResponseEntity<>(_student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
