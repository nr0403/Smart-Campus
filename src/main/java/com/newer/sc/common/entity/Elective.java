package com.newer.sc.common.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 选修课
 * @author Amichen
 *
 */
@Component 
public class Elective {
	
	Integer elid;
	
	String elname;
	
	Date eltime;
	
	String eladdress;
	
	Student student;
	
	String elweek;

	public Integer getElid() {
		return elid;
	}

	public void setElid(Integer elid) {
		this.elid = elid;
	}

	public String getElname() {
		return elname;
	}

	public void setElname(String elname) {
		this.elname = elname;
	}

	public Date getEltime() {
		return eltime;
	}

	public void setEltime(Date eltime) {
		this.eltime = eltime;
	}

	public String getEladdress() {
		return eladdress;
	}

	public void setEladdress(String eladdress) {
		this.eladdress = eladdress;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getElweek() {
		return elweek;
	}

	public void setElweek(String elweek) {
		this.elweek = elweek;
	}
	
}
