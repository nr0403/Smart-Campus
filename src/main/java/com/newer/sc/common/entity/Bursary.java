package com.newer.sc.common.entity;

import org.springframework.stereotype.Component;

/**
 * 奖学金
 * @author Amichen
 *
 */
@Component
public class Bursary {
	Integer bid;
	
	Student student;
	
	Credit credit;
	
	Integer bmoney;
<<<<<<< HEAD
	
	Integer bstat;
	
	public Integer getBstat() {
		return bstat;
	}

	public void setBstat(Integer bstat) {
		this.bstat = bstat;
	}
=======
>>>>>>> parent of 2bd4d1f... 教师后端接口

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public Integer getBmoney() {
		return bmoney;
	}

	public void setBmoney(Integer bmoney) {
		this.bmoney = bmoney;
	}

	public Integer getBstat() {
		return bstat;
	}

	public void setBstat(Integer bstat) {
		this.bstat = bstat;
	}
	
	
}
