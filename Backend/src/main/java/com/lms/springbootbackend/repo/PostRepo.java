package com.lms.springbootbackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.springbootbackend.model.Post;

public interface PostRepo extends JpaRepository<Post, Long>{

    //  find the posts of a course
    List<Post> findByCourseCourseId(Long course_id);

}
