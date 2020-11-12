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
	
	
}
