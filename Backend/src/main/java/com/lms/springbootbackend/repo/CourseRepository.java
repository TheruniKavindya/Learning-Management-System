package com.lms.springbootbackend.repo;

import com.lms.springbootbackend.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {

    Courses findCourseByCourseTitleEquals(String title);
    List<Courses> findAllByCreditHour(double credit_hour);
    Courses findCourseByCourseCode(String course_code);
    List<Courses> findCourseByCourseGrade(String grade);
}
