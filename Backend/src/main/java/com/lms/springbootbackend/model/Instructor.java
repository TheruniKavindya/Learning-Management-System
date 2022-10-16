package com.lms.springbootbackend.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @SequenceGenerator(name = "instructorId_seq", sequenceName = "instructorId_seq", allocationSize = 1, initialValue = 600000)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "instructorId_seq")

    private long instructorId;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;


    @Column (name = "password")
    private String password;
    @Column (name = "phone")
    private String phone;

    @Column(name = "dob")
    private Date dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "photo_url")
    private String photo_url;

    @Column(name = "designation")
    private String designation;

    //    speciality
    @Column(name = "speciality")
    private String speciality;

    @Column(name = "ofice_number")
    private int office_number;

    //    establish relationship with course  table
//    many to many
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "instructor_course",
            joinColumns = @JoinColumn(name = "instructorId"),
            inverseJoinColumns = @JoinColumn(name = "courseId"))
    private Set<Course> courses = new HashSet<>();

    public Instructor() {
        super();
    }

    public Instructor(long instructorId, String name, String email, String password, String phone, Date dateOfBirth,
                      String address, String photo_url, String designation, String speciality, int office_number,
                      Set<Course> courses) {
        super();
        this.instructorId = instructorId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.photo_url = photo_url;
        this.designation = designation;
        this.speciality = speciality;
        this.office_number = office_number;
        this.courses = courses;
    }

    public long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getOffice_number() {
        return office_number;
    }

    public void setOffice_number(int office_number) {
        this.office_number = office_number;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor [instructorId=" + instructorId + ", name=" + name + ", email=" + email + ", password="
                + password + ", phone=" + phone + ", dateOfBirth=" + dateOfBirth + ", address=" + address
                + ", photo_url=" + photo_url + ", designation=" + designation + ", speciality=" + speciality
                + ", office_number=" + office_number + ", courses=" + courses + "]";
    }



}
