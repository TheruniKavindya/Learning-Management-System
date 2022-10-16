package com.lms.springbootbackend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Courses {

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
