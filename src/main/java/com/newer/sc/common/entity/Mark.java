package com.newer.sc.common.entity;

import org.springframework.stereotype.Component;

/**
 * 教学评分
 * @author Amichen
 *
 */
@Component
public class Mark {
	
	Integer mid;
	
	Teacher teacher;
	
	Integer mscore;
	
	Course course;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getMscore() {
		return mscore;
	}

	public void setMscore(Integer mscore) {
		this.mscore = mscore;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
