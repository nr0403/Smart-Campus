package com.newer.sc.common.entity;

import java.math.BigInteger;
import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 班级
 * @author Amichen
 *
 */
@Component
public class Class {
	
	BigInteger cid;
	
	String cname;
	
	Teacher teacher;
	
	Major major;
	
	Date ctime;

	public BigInteger getCid() {
		return cid;
	}

	public void setCid(BigInteger cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	
	
	
}
