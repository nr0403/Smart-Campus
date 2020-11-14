package com.newer.sc.common.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 学生
 * @author Amichen
 *
 */
@Component
public class Student {
	
	int sid;
	
	String sname;
	
	String sphone;
	
	String spassword;
	
	Date sbirthday;
	
	String ssfz;
	
	Class class1;
	
	Integer sgraduate;
	
	College college;
	
	Major major;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public Date getSbirthday() {
		return sbirthday;
	}

	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}

	public String getSsfz() {
		return ssfz;
	}

	public void setSsfz(String ssfz) {
		this.ssfz = ssfz;
	}

	public Class getClass1() {
		return class1;
	}

	public void setClass1(Class class1) {
		this.class1 = class1;
	}

	public Integer getSgraduate() {
		return sgraduate;
	}

	public void setSgraduate(Integer sgraduate) {
		this.sgraduate = sgraduate;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sphone=" + sphone + ", spassword=" + spassword
				+ ", sbirthday=" + sbirthday + ", ssfz=" + ssfz + ", class1=" + class1 + ", sgraduate=" + sgraduate
				+ ", college=" + college + ", major=" + major + "]";
	}
	
}
