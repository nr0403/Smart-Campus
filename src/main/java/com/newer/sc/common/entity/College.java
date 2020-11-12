package com.newer.sc.common.entity;

import org.springframework.stereotype.Component;

/**
 * 学院
 * @author Amichen
 *
 */
@Component
public class College {
	
	Integer coid;
	
	String coname;
	
	// 学院介绍
	String covalue;

	public Integer getCoid() {
		return coid;
	}

	public void setCoid(Integer coid) {
		this.coid = coid;
	}

	public String getConame() {
		return coname;
	}

	public void setConame(String coname) {
		this.coname = coname;
	}

	public String getCovalue() {
		return covalue;
	}

	public void setCovalue(String covalue) {
		this.covalue = covalue;
	}
	
}
