package com.newer.sc.common.entity;

import org.springframework.stereotype.Component;

/**
 * 课程
 * @author Amichen
 *
 */
@Component
public class Course {
	
	Integer couid;
	
	String couname;
	
	String cougrade;
	
	String coujc;
	
	Integer couhour;

	public Integer getCouid() {
		return couid;
	}

	public void setCouid(Integer couid) {
		this.couid = couid;
	}

	public String getCouname() {
		return couname;
	}

	public void setCouname(String couname) {
		this.couname = couname;
	}

	public String getCougrade() {
		return cougrade;
	}

	public void setCougrade(String cougrade) {
		this.cougrade = cougrade;
	}

	public String getCoujc() {
		return coujc;
	}

	public void setCoujc(String coujc) {
		this.coujc = coujc;
	}

	public Integer getCouhour() {
		return couhour;
	}

	public void setCouhour(Integer couhour) {
		this.couhour = couhour;
	}
	
}
