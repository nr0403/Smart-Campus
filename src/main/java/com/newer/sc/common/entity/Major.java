package com.newer.sc.common.entity;

import org.springframework.stereotype.Component;

/**
 * 专业
 * @author Amichen
 *
 */
@Component
public class Major {
	
	Integer maid;
	
	String maname;
	
	College college;

	public Integer getMaid() {
		return maid;
	}

	public void setMaid(Integer maid) {
		this.maid = maid;
	}

	public String getManame() {
		return maname;
	}

	public void setManame(String maname) {
		this.maname = maname;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
}
