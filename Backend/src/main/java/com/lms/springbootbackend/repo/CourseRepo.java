package com.lms.springbootbackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.springbootbackend.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{

    Course findCourseByCourseTitleEquals(String title);
    List<Course> findAllByCreditHour(double credit_hour);
    Course findCourseByCourseCode(String course_code);
    List<Course> findCourseByCourseGrade(String grade);

}
