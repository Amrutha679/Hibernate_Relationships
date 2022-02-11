package com.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="studentid")
	private Set obj2;

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

	public Set getObj2() {
		return obj2;
	}

	public void setObj2(Set obj2) {
		this.obj2 = obj2;
	}
}
