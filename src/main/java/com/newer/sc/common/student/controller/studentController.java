package com.newer.sc.common.student.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.sc.common.entity.Ccie;
import com.newer.sc.common.entity.Check;
import com.newer.sc.common.entity.Credit;
import com.newer.sc.common.entity.Ctimetable;
import com.newer.sc.common.entity.Elective;
import com.newer.sc.common.entity.Exam;
import com.newer.sc.common.entity.Grade;
import com.newer.sc.common.entity.Student;
import com.newer.sc.common.entity.Teacher;
import com.newer.sc.common.student.servic.StudentService;

@RestController
@RequestMapping
public class studentController {

	@Autowired
	StudentService stu;

	@GetMapping("/student/{id}")
//	查询单个学生信息
	public Student findByid(@PathVariable BigInteger id) {
		return stu.findByid(id);
	}

//	通过班级查询考试
	@GetMapping("/student/examination/{id}")
	public List<Exam> findByClass(@PathVariable BigInteger id) {
		return stu.findByClass(id);
	}

//	学生查询班级考试信息
	@GetMapping("/student/class/examination/{id}")
	public List<Exam> findByStudentClass(@PathVariable BigInteger id) {
		return stu.findByStudentClass(id);
	}

	@GetMapping("/student/timetable/{id}")
//	通过学生查班级课表
	public List<Ctimetable> findtimetable(@PathVariable BigInteger id) {
		return stu.findtimetable(id);
	}

//	通过学生id查学分
	@GetMapping("/student/credit/{id}")
	public Credit findCredit(@PathVariable int id) {
		return stu.findCredit(id);
	}

//	学生通过id查询考勤信息
	@GetMapping("/student/che/{id}")
	public List<Check> findCheck(@PathVariable int id) {
		return stu.findCheck(id);
	}

//	学生申请奖学金
	@PostMapping("/student/apply/{sid}")
	public void insertBursary(@PathVariable int sid) {
		stu.insertBursary(sid);
	}

//	学生查询分数
	@GetMapping("/student/grade/{id}")
	public List<Grade> findGrade(@PathVariable int id) {
		return stu.findBySid(id);
	}

//	查询所有等级考试信息
	@GetMapping("/student/apply/lebel")
	public List<Ccie> findAllCcie(){
		return stu.findAllCcie();
	}
	
//	学生报名登记考试
	@PostMapping("/student/apply/lebel/{cid}/{id}")
	public void insertCcie(@PathVariable int cid,@PathVariable int id) {
		stu.insertCcie(cid, id);
	}
	
//	查询所有选修课表
	@GetMapping("/student/apply/course")
	public List<Elective> findAllEle(){
	return	stu.findAllEle();
	}
	
//	学生报名选修课
	@PostMapping("/student/apply/course/{eid}/{id}")
	public void insertEle(@PathVariable int eid,@PathVariable int id) {
		stu.insertEle(eid, id);
	}
	
//	查寻所有老师
	@GetMapping("/student/teacher")
	public List<Teacher> findAllTea(){
	return	stu.findAllTea();
	}
	
//	学生给老师评分
	@PostMapping("/student/teacher/{tid}/{score}")
	public void insertMark(@PathVariable int tid,@PathVariable int score) {
		stu.insertMark(tid, score);
	}
	
//	学生申请补考
	@PostMapping("/student/exam/{sid}/{eid}/{state}")
	public void insertExam(@PathVariable int sid,@PathVariable int eid,@PathVariable int state){
		stu.insertExam(sid, eid, state);
	}
}
