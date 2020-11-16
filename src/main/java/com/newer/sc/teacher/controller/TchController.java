package com.newer.sc.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newer.sc.common.entity.Check;
import com.newer.sc.common.entity.Ctimetable;
import com.newer.sc.common.entity.Grade;
import com.newer.sc.common.entity.Student;
import com.newer.sc.common.entity.Teacher;
import com.newer.sc.teacher.mapper.TchMapper;

@RestController
public class TchController {

		@Autowired
		TchMapper tm;
		
		//查询课表
		@GetMapping("/ctimetable/{id}")
		public List<Ctimetable> findCtimeById(@PathVariable int id) {
			return tm.findTimeById(id);
		}
		
		//查询老师个人信息
		@GetMapping("/teacher/{id}")
		public Teacher findById(@PathVariable int id) {
			return tm.findById(id);
		}
		
		//查询班级花名册
		@GetMapping("/class/{id}")
		public List<Student> findAllStuByClzId(@PathVariable int id){
			return tm.findAllStuByClzId(id);
		}
		
		//创建学生成绩
		@PostMapping
		public void createGrade(@RequestBody Grade grade) {
			tm.createGrade(grade);
		}
		
		//修改学生成绩
		@PutMapping("/{id}")
		public void updateGrade(@PathVariable int id,@RequestBody Grade grade) {
			Student stu=new Student();
			stu.setSid(id);
			grade.setStudent(stu);
			tm.updateGrade(grade);
		}
		
		//提交学生考勤
		@PostMapping("/check")
		public void createCheck(@RequestBody Check check) {
			System.out.println("日期："+check.getChdate());
			tm.createCheck(check);
		}
}
