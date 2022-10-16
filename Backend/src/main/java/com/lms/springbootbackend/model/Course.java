package com.lms.springbootbackend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
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
