package com.newer.sc.common.entity;

import org.springframework.stereotype.Component;

/**
 * 学分
 * @author Amichen
 *
 */
@Component
public class Credit {
	
	Integer crid;
	
	Grade grade;
	
	Check check;
	
	Student student;
	
	Integer crhour;

	public Integer getCrid() {
		return crid;
	}

	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getCrhour() {
		return crhour;
	}

	public void setCrhour(Integer crhour) {
		this.crhour = crhour;
	}
	
}
