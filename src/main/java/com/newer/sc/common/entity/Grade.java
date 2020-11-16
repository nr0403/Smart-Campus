package com.newer.sc.common.entity;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * 成绩
 * @author Amichen
 *
 */
@Component
public class Grade {
	
	
	Integer gid;
	
	Student student;
	
	Integer gscore;
	
	Exam exam;
	
	Ccie ccie;	

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getGscore() {
		return gscore;
	}

	public void setGscore(Integer gscore) {
		this.gscore = gscore;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Ccie getCcie() {
		return ccie;
	}

	public void setCcie(Ccie ccie) {
		this.ccie = ccie;
	}
	
	
}
