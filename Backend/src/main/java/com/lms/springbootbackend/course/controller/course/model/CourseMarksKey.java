package com.lms.springbootbackend.course.controller.course.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseMarksKey implements Serializable {
    @Column(name = "student_id")
    Long studentId;

    @Column(name = "course_code")
    String courseCode;

}
