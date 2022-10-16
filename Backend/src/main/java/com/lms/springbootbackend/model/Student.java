package com.lms.springbootbackend.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;

	@Column(name = "roll", unique = true)
	private int roll;

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private String phone;

	@Column(name = "dob", columnDefinition = "DATE")
	private Date dateOfBirth;

	@Column(name = "address")
	private String address;

	@Column(name = "photo_url")
	private String photo_url;

	@Column(name = "grade_no")
	private String grade;

	@Column(name = "shift")
	private String shift;

	@Column(name = "section")
	private String section;

	@Column(name = "session")
	private String session;

	@Column(name = "cgpa")
	private double cgpa;

	@Column(name = "is_regular")
	private boolean is_regular;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Submission> submissionList;

	//    establish A many to many relationship with the course class
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "course_student",
			joinColumns = @JoinColumn(name = "studentId"),
			inverseJoinColumns = @JoinColumn(name = "courseId")
	)
	private List<Course> courseList;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "tutorial_tags",
			joinColumns = { @JoinColumn(name = "studentId") },
			inverseJoinColumns = { @JoinColumn(name = "courseId") })
	private Set<Course> courses = new HashSet<>();

	public Student() {
		super();
	}

	public Student(long studentId, int roll, String firstname, String lastname, String email, String password,
				   String phone, Date dateOfBirth, String address, String photo_url, String grade, String shift,
				   String section, String session, double cgpa, boolean is_regular, List<Submission> submissionList,
				   List<Course> courseList, Set<Course> courses) {
		super();
		this.studentId = studentId;
		this.roll = roll;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.photo_url = photo_url;
		this.grade = grade;
		this.shift = shift;
		this.section = section;
		this.session = session;
		this.cgpa = cgpa;
		this.is_regular = is_regular;
		this.submissionList = submissionList;
		this.courseList = courseList;
		this.courses = courses;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public boolean isIs_regular() {
		return is_regular;
	}

	public void setIs_regular(boolean is_regular) {
		this.is_regular = is_regular;
	}

	public List<Submission> getSubmissionList() {
		return submissionList;
	}

	public void setSubmissionList(List<Submission> submissionList) {
		this.submissionList = submissionList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", roll=" + roll + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", password=" + password + ", phone=" + phone + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", photo_url=" + photo_url + ", grade=" + grade + ", shift="
				+ shift + ", section=" + section + ", session=" + session + ", cgpa=" + cgpa + ", is_regular="
				+ is_regular + ", submissionList=" + submissionList + ", courseList=" + courseList + ", courses="
				+ courses + "]";
	}



}
