package com.newer.sc.student.service;

import java.math.BigInteger;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.newer.sc.common.entity.Ccie;
import com.newer.sc.common.entity.CcieStu;
import com.newer.sc.common.entity.Check;
import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.Credit;
import com.newer.sc.common.entity.Ctimetable;
import com.newer.sc.common.entity.Ele_Stu;
import com.newer.sc.common.entity.Elective;
import com.newer.sc.common.entity.Exam;
import com.newer.sc.common.entity.ExamStu;
import com.newer.sc.common.entity.Grade;
import com.newer.sc.common.entity.Student;
import com.newer.sc.common.entity.Teacher;
import com.newer.sc.student.mapper.studentMapper;

@Service
public class StudentService {

	@Autowired
	studentMapper stumapper;

//	查询单个学生信息
	public Student findByid(BigInteger id) {
		return stumapper.findByid(id);
	}

//	通过班级查询考试
	public List<Exam> findByClass(BigInteger id) {
		Class findStudentClass = stumapper.findStudentClass(id);
		return stumapper.findByStudentClass(findStudentClass.getCid());
	}

//	通过学生查班级考试信息
	public List<Exam> findByStudentClass(BigInteger id) {
		Student stu = stumapper.findByid(id);
		Class class1 = stu.getClass1();
		BigInteger cid = class1.getCid();
		return stumapper.findByStudentClass(cid);
	}

//	通过学生查班级课表
	public List<Ctimetable> findtimetable(BigInteger id) {
		Student student = stumapper.findByid(id);
		Class class1 = student.getClass1();
		BigInteger cid = class1.getCid();
		return stumapper.findCtimeTableByClassId(cid);
	}

//	学生通过学号查询学分
	public Credit findCredit(BigInteger id) {
		return stumapper.findCreditById(id);
	}

//	学生通过id查考勤信息
	public List<Check> findCheck(BigInteger id) {
		return stumapper.findCheck(id);
	}

//	学生申请奖学金
	public void insertBursary(BigInteger sid) {
		Credit findCredit = stumapper.findCreditById(sid);
		Integer crid = findCredit.getCrid();
		stumapper.insertBursary(sid, crid);
	}

//	学生查询分数
	public List<Grade> findBySid(BigInteger id) {
		return stumapper.findGrade(id);
	}

//	查询所有等级考试信息
	public List<Ccie> findAllCcie() {
		return stumapper.findAllCcie();
	}

//	学生报名登记考试 
	public void insertCcie(int cid, BigInteger id) {
		stumapper.insertCcie(cid, id);
	}

//	查询所有选修课
	public List<Elective> findAllEle() {
		return stumapper.findAllEle();
	}

//	学生报名选修课
	public void insertEle(int eid, BigInteger id) {
		stumapper.insertEle(eid, id);
	}

//	查询所有老师
	public List<Teacher> findAllTea() {
		return stumapper.findAllTea();
	}

//	学生给老师评分
	public void insertMark(int tid, int score) {
		stumapper.insertMark(tid, score);
	}

//	学生申请补考
	public void insertExam(BigInteger sid, int eid) {
		stumapper.insertExam(sid, eid);
	}

	// 学生已申请的补考
	public List<ExamStu> findExamBysid(BigInteger id) {
		return stumapper.findExamBysid(id);
	}

//	查询已申请的证书
	public List<CcieStu> findCcieBySid(BigInteger id) {
		return stumapper.findCcieBySid(id);
	}

//	查看报名的等级考试
	public List<Ele_Stu> findEleStu(BigInteger id) {
		return stumapper.findEleStu(id);
	}
	
//	学生修改信息
	public void updateStu(Student student) {
		stumapper.updateStu(student);
		
	}
//  学生修改信息
  public void upStu(BigInteger sid,String pass) {
	  stumapper.UpStu(sid, pass);
    
  }
}
