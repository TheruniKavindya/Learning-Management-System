package com.lms.springbootbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.springbootbackend.model.CourseMaterials;

import java.util.List;

public interface CourseMaterialsRepo extends JpaRepository<CourseMaterials, Long>{

    List<CourseMaterials> findByCourseCourseId(Long course_id);

}
