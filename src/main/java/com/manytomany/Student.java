package com.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onetomany.Customers;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="sid")
	private int studentId;
	
	@Column(name="sname")
	private String studentName;
	
	@ManyToMany(fetch=FetchType.LAZY,targetEntity = Course.class,cascade = CascadeType.ALL)
	@JoinColumn(name="courseid")
	private Set obj;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Set getObj() {
		return obj;
	}

	public void setObj(Set obj) {
		this.obj = obj;
	}
	
}
