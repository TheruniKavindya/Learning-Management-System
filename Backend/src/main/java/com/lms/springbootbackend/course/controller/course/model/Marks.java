package com.lms.springbootbackend.course.controller.course.model;



import com.lms.springbootbackend.appuser.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Marks {

    @EmbeddedId
    CourseMarksKey id;


    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private AppUser student;

    @ManyToOne
    @MapsId("courseCode")
    @JoinColumn(name = "course_code")
    private Course course;
    private long markss;

}
