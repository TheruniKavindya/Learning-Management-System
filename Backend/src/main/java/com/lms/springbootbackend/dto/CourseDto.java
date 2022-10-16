package com.lms.springbootbackend.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
//@NoArgsConstructor
public class CourseDto {
    private String courseCode;
    private String courseName;
    private String academicYear;
}
