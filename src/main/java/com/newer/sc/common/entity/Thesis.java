package com.newer.sc.common.entity;

/**
 * 毕业设计
 * @author Amichen
 *
 */
public class Thesis {
	Integer thid;
	
	Student student;
	
	String thvalue;
	
	Integer thresult;

	public Integer getThid() {
		return thid;
	}

	public void setThid(Integer thid) {
		this.thid = thid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getThvalue() {
		return thvalue;
	}

	public void setThvalue(String thvalue) {
		this.thvalue = thvalue;
	}

	public Integer getThresult() {
		return thresult;
	}

	public void setThresult(Integer thresult) {
		this.thresult = thresult;
	}
	
	
}
