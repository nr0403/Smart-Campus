package com.newer.sc.common.entity;

public class ExamStu {

	int esid;
	Student student;
	Exam exam;
	int estate;
	public int getEsid() {
		return esid;
	}
	public void setEsid(int esid) {
		this.esid = esid;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public int getEstate() {
		return estate;
	}
	public void setEstate(int estate) {
		this.estate = estate;
	}
}
