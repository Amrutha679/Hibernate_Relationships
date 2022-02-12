package com.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="cid")
	private int courseId;
	
	@Column(name="cname")
	private String courseName;
	
	@ManyToMany(fetch=FetchType.LAZY,targetEntity = Student.class,cascade = CascadeType.ALL)
	@JoinTable(name="student_course",
    joinColumns=@JoinColumn(name="cid"),
    inverseJoinColumns=@JoinColumn(name="sid"))
	private Set<Student> students;

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
