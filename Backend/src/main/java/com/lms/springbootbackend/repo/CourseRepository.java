package com.lms.springbootbackend.repo;

import com.lms.springbootbackend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findCourseByCourseTitleEquals(String title);
    List<Course> findAllByCreditHour(double credit_hour);
    Course findCourseByCourseCode(String course_code);
    List<Course> findCourseByCourseGrade(String grade);
}
