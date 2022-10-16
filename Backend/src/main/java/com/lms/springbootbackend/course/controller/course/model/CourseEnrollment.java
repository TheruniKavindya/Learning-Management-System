package com.lms.springbootbackend.course.controller.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseEnrollment {
    @Id
    private int studentId;
    private String code;
    private String course_name;
    private String course_description;

}
