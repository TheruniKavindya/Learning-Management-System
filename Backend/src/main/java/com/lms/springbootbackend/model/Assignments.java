package com.lms.springbootbackend.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "assignments")
public class Assignments {

    @Id
    @SequenceGenerator(name = "assignmentId_seq", sequenceName = "assignmentId_seq", allocationSize = 1, initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "assignmentId_seq")

    private long assignmentId;

    @Column(name = "ass_title")
    private String assTitle;

    @Column(name = "spec_file_link")
    private String specFileLink;
    @Column(name = "ass_due_date")
    private Date assignmentDueDate;

    @Column(name = "description")
    private String description;

    @Column(name="points")
    private Double points;

    @Column(name = "session")
    private String session;

    //    establish a many to one relationship with the course  class
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "courseId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;


    public Assignments() {
    }


    public Assignments(long assignmentId, String assTitle, String specFileLink, Date assignmentDueDate,
                       String description, Double points, String session, Course course) {
        super();
        this.assignmentId = assignmentId;
        this.assTitle = assTitle;
        this.specFileLink = specFileLink;
        this.assignmentDueDate = assignmentDueDate;
        this.description = description;
        this.points = points;
        this.session = session;
        this.course = course;
    }


    public long getAssignmentId() {
        return assignmentId;
    }


    public void setAssignmentId(long assignmentId) {
        this.assignmentId = assignmentId;
    }


    public String getAssTitle() {
        return assTitle;
    }


    public void setAssTitle(String assTitle) {
        this.assTitle = assTitle;
    }


    public String getSpecFileLink() {
        return specFileLink;
    }


    public void setSpecFileLink(String specFileLink) {
        this.specFileLink = specFileLink;
    }


    public Date getAssignmentDueDate() {
        return assignmentDueDate;
    }


    public void setAssignmentDueDate(Date assignmentDueDate) {
        this.assignmentDueDate = assignmentDueDate;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Double getPoints() {
        return points;
    }


    public void setPoints(Double points) {
        this.points = points;
    }


    public String getSession() {
        return session;
    }


    public void setSession(String session) {
        this.session = session;
    }


    public Course getCourse() {
        return course;
    }


    public void setCourse(Course course) {
        this.course = course;
    }


    @Override
    public String toString() {
        return "Assignments [assignmentId=" + assignmentId + ", assTitle=" + assTitle + ", specFileLink=" + specFileLink
                + ", assignmentDueDate=" + assignmentDueDate + ", description=" + description + ", points=" + points
                + ", session=" + session + ", course=" + course + "]";
    }



}
