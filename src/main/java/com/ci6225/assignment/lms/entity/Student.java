package com.ci6225.assignment.lms.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	int id;
	String email;
	String password;
	String full_name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
        name = "student_enrollment", 
        joinColumns = { @JoinColumn(name = "student_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
	private List<Course> courses;
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return email;
	}
	public void setUsername(String username) {
		this.email = username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return full_name;
	}
	public void setFullname(String fullname) {
		this.full_name = fullname;
	}
	
	@Override
	public String toString() {
		return full_name;
	}
}
