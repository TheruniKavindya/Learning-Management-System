package com.lms.springbootbackend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name = "course_category")
@Getter
@Setter
@ToString
public class CourseCategory {
    @Id
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "category_description")
    private String categoryDescription;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
