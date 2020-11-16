package com.newer.sc.common.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 考勤
 * @author Amichen
 *
 */
@Component
public class Check {
	
	Integer chid;
	
	Student student;
	
	Date chdate;
	
	Integer chstate;
	
	Ctimetable ctimetable;

	public Integer getChid() {
		return chid;
	}

	public void setChid(Integer chid) {
		this.chid = chid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getChdate() {
		return chdate;
	}

	public void setChdate(Date chdate) {
		this.chdate = chdate;
	}

	public Integer getChstate() {
		return chstate;
	}

	public void setChstate(Integer chstate) {
		this.chstate = chstate;
	}

	public Ctimetable getCtimetable() {
		return ctimetable;
	}

	public void setCtimetable(Ctimetable ctimetable) {
		this.ctimetable = ctimetable;
	}
	
	
	
}
