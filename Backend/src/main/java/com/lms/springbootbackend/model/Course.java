package com.lms.springbootbackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseId;

    private String courseCode;

    private String courseTitle;

    private double creditHour;

    private String courseDescription;

    private Double courseMarks;

    private String courseGrade;

    private String coursePrerequisite;
}
