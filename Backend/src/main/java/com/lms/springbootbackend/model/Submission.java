package com.lms.springbootbackend.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "submission")
public class Submission {

    @Id
    @SequenceGenerator(name = "submissionId_seq", sequenceName = "submissionId_seq", allocationSize = 1, initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "submissionId_seq")
    private long submissionId;

    //establishing the relationship between submission and student
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studentId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    private Student student;

    //establishing the relationship between submission and student
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assignmentId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    private Assignments assignment;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "submission_time")
    private Date submissionTime;
    @Column(name = "total_attempts")
    private int total_attempts;

    @Column(name = "grading_status")
    private String grading_status;

    @Column(name = "sub_file_link")
    private String sub_file_link;

    public Submission() {
    }

    public Submission(long submissionId, Student student, Assignments assignment, Date deadline, Date submissionTime,
                      int total_attempts, String grading_status, String sub_file_link) {
        super();
        this.submissionId = submissionId;
        this.student = student;
        this.assignment = assignment;
        this.deadline = deadline;
        this.submissionTime = submissionTime;
        this.total_attempts = total_attempts;
        this.grading_status = grading_status;
        this.sub_file_link = sub_file_link;
    }

    public long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(long submissionId) {
        this.submissionId = submissionId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assignments getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignments assignment) {
        this.assignment = assignment;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public int getTotal_attempts() {
        return total_attempts;
    }

    public void setTotal_attempts(int total_attempts) {
        this.total_attempts = total_attempts;
    }

    public String getGrading_status() {
        return grading_status;
    }

    public void setGrading_status(String grading_status) {
        this.grading_status = grading_status;
    }

    public String getSub_file_link() {
        return sub_file_link;
    }

    public void setSub_file_link(String sub_file_link) {
        this.sub_file_link = sub_file_link;
    }

    @Override
    public String toString() {
        return "Submission [submissionId=" + submissionId + ", student=" + student + ", assignment=" + assignment
                + ", deadline=" + deadline + ", submissionTime=" + submissionTime + ", total_attempts=" + total_attempts
                + ", grading_status=" + grading_status + ", sub_file_link=" + sub_file_link + "]";
    }


}
