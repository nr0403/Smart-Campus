package com.newer.sc.common.student.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.newer.sc.common.entity.Ccie;
import com.newer.sc.common.entity.Check;
import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.Credit;
import com.newer.sc.common.entity.Ctimetable;
import com.newer.sc.common.entity.Elective;
import com.newer.sc.common.entity.Exam;
import com.newer.sc.common.entity.Grade;
import com.newer.sc.common.entity.Student;
import com.newer.sc.common.entity.Teacher;
import com.newer.sc.common.student.mapper.studentMapper;

@Service
public class StudentService {

	@Autowired
	studentMapper stumapper;

//	查询单个学生信息
	public Student findByid(int id) {
		return stumapper.findByid(id);
	}

//	通过班级查询考试
	public List<Exam> findByClass(int id) {
		Class findStudentClass = stumapper.findStudentClass(id);
		return stumapper.findByStudentClass(findStudentClass.getCid());
	}

//	通过学生查班级考试信息
	public List<Exam> findByStudentClass(int id) {
		Student stu = stumapper.findByid(id);
		Class class1 = stu.getClass1();
		Integer cid = class1.getCid();
		return stumapper.findByStudentClass(cid);
	}

//	通过学生查班级课表
	public List<Ctimetable> findtimetable(int id) {
		Student student = stumapper.findByid(id);
		Class class1 = student.getClass1();
		Integer cid = class1.getCid();
		return stumapper.findCtimeTableByClassId(cid);
	}

//	学生通过学号查询学分
	public Credit findCredit(int id) {
		return stumapper.findCreditById(id);
	}

//	学生通过id查考勤信息
	public List<Check> findCheck(int id) {
		return stumapper.findCheck(id);
	}

//	学生申请奖学金
	public void insertBursary(int sid) {
		Credit findCredit = stumapper.findCreditById(sid);
		Integer crid = findCredit.getCrid();
		stumapper.insertBursary(sid, crid);
	}

//	学生查询分数
	public List<Grade> findBySid(int id) {
		return stumapper.findGrade(id);
	}

//	查询所有等级考试信息
	public List<Ccie> findAllCcie() {
		return stumapper.findAllCcie();
	}

//	学生报名登记考试 
	public void insertCcie(int cid, int id) {
		stumapper.insertCcie(cid, id);
	}

//	查询所有选修课
	public List<Elective> findAllEle() {
		return stumapper.findAllEle();
	}

//	学生报名选修课
	public void insertEle(int eid, int id) {
		stumapper.insertEle(eid, id);
	}

//	查询所有老师
	public List<Teacher> findAllTea() {
		return stumapper.findAllTea();
	}
	
//	学生给老师评分
	public void insertMark(int tid,int score) {
		stumapper.insertMark(tid, score);
	}
	
//	学生申请补考
	public void insertExam(int sid,int eid,int state) {
		stumapper.insertExam(sid, eid, state);
	}
}
