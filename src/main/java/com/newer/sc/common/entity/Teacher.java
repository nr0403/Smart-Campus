package com.newer.sc.common.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 教师
 * @author Amichen
 *
 */
@Component
public class Teacher {
	
	Long tid;
	
	String tname;
	
	String tpassword;
	
	String tsfz;
	
	String tphone;
	
	Date tbirthday;
	
	Integer tlevel;
	
	College college;

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	public String getTsfz() {
		return tsfz;
	}

	public void setTsfz(String tsfz) {
		this.tsfz = tsfz;
	}

	public String getTphone() {
		return tphone;
	}

	public void setTphone(String tphone) {
		this.tphone = tphone;
	}

	public Date getTbirthday() {
		return tbirthday;
	}

	public void setTbirthday(Date tbirthday) {
		this.tbirthday = tbirthday;
	}

	public Integer getTlevel() {
		return tlevel;
	}

	public void setTlevel(Integer tlevel) {
		this.tlevel = tlevel;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
	
	
}
