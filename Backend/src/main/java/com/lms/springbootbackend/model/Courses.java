package com.lms.springbootbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
