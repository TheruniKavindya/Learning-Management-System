package com.lms.springbootbackend.course.controller.course.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name = "student_enrolled")
public class StudentEnroll {

    //@GeneratedValue(strategy = GenerationType.IDENTITY )
    private String course_code;
    @Id
    private int enrolled_students_id;
}
