package com.newer.sc.common.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 考试
 * @author Amichen
 *
 */
@Component
public class Exam {
	
	Integer eid;
	
	String ename;
	
	Date etime;
	
	String eaddress;
	
	// 班级
	Class class1;
	
	// 课程
	Course course;
	
	Integer estate;
	
	Student student;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public Class getClass1() {
		return class1;
	}

	public void setClass1(Class class1) {
		this.class1 = class1;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getEstate() {
		return estate;
	}

	public void setEstate(Integer estate) {
		this.estate = estate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
