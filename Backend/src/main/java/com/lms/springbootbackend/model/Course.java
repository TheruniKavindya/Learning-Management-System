package com.lms.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long courseId;

    @Column(name = "course_code",unique = true)
    private String courseCode;

    @Column(name = "course_title", unique = true)
    private String courseTitle;

    @Column(name = "credit_hour")
    private double creditHour;

    @Column (name = "course_description")
    private String courseDescription;

    @Column (name = "course_marks")
    private Double courseMarks;

    @Column (name = "course_grade")
    private String courseGrade;
    @Column (name = "course_prerequisite")
    private String coursePrerequisite;

    public Course() {
        super();
    }

    public Course(long courseId, String courseCode, String courseTitle, double creditHour, String courseDescription,
                  Double courseMarks, String courseGrade, String coursePrerequisite) {
        super();
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.creditHour = creditHour;
        this.courseDescription = courseDescription;
        this.courseMarks = courseMarks;
        this.courseGrade = courseGrade;
        this.coursePrerequisite = coursePrerequisite;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(double creditHour) {
        this.creditHour = creditHour;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Double getCourseMarks() {
        return courseMarks;
    }

    public void setCourseMarks(Double courseMarks) {
        this.courseMarks = courseMarks;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getCoursePrerequisite() {
        return coursePrerequisite;
    }

    public void setCoursePrerequisite(String coursePrerequisite) {
        this.coursePrerequisite = coursePrerequisite;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseCode=" + courseCode + ", courseTitle=" + courseTitle
                + ", creditHour=" + creditHour + ", courseDescription=" + courseDescription + ", courseMarks="
                + courseMarks + ", courseGrade=" + courseGrade + ", coursePrerequisite=" + coursePrerequisite + "]";
    }

}
