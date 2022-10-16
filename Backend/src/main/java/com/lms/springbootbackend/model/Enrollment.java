package com.lms.springbootbackend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "enrollment")
@Getter
@Setter
@ToString
public class Enrollment implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "stu_id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "enrollment_date")
    private Date enrollmentDate;

    @Column(name = "cancelled")
    private Boolean cancelled;

    @Column(name = "cancelled_date")
    private Date cancelledDate;

    @Column(name = "cancellation_reason")
    private String cancellationReason;
}
