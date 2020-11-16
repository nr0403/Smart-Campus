package com.newer.sc.common.entity;


import org.springframework.stereotype.Component;

/**
 * 课表
 * @author Amichen
 *
 */
@Component
public class Ctimetable {
	
	int ctid;
	
	String ctname;
	
	Class class1;
	
	Teacher teacher;
	
	String ctweek;
	
	String cttime;
	
	String ctcycle;

	public int getCtid() {
		return ctid;
	}

	public void setCtid(int ctid) {
		this.ctid = ctid;
	}

	public String getCtname() {
		return ctname;
	}

	public void setCtname(String ctname) {
		this.ctname = ctname;
	}

	public Class getClass1() {
		return class1;
	}

	public void setClass1(Class class1) {
		this.class1 = class1;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getCtweek() {
		return ctweek;
	}

	public void setCtweek(String ctweek) {
		this.ctweek = ctweek;
	}

	public String getCttime() {
		return cttime;
	}

	public void setCttime(String cttime) {
		this.cttime = cttime;
	}

	public String getCtcycle() {
		return ctcycle;
	}

	public void setCtcycle(String ctcycle) {
		this.ctcycle = ctcycle;
	}
}
