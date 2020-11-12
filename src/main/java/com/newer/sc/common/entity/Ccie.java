package com.newer.sc.common.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 证书考试
 * @author Amichen
 *
 */
@Component
public class Ccie {
	
	Integer ccid;
	
	String ccname;
	
	Student student;
	
	Date cctime;
	
	String ccaddress;

	public Integer getCcid() {
		return ccid;
	}

	public void setCcid(Integer ccid) {
		this.ccid = ccid;
	}

	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getCctime() {
		return cctime;
	}

	public void setCctime(Date cctime) {
		this.cctime = cctime;
	}

	public String getCcaddress() {
		return ccaddress;
	}

	public void setCcaddress(String ccaddress) {
		this.ccaddress = ccaddress;
	}
	
	

}
