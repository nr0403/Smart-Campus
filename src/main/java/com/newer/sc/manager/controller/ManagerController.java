package com.newer.sc.manager.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.College;
import com.newer.sc.common.entity.Major;
import com.newer.sc.common.entity.Student;
import com.newer.sc.common.entity.Teacher;
import com.newer.sc.manager.mapper.MclassMapper;
import com.newer.sc.manager.mapper.McollegeMapper;
import com.newer.sc.manager.mapper.MmajorMapper;
import com.newer.sc.manager.mapper.MstudentMapper;
import com.newer.sc.manager.mapper.MteacherMapper;

@RestController
@RequestMapping("/admin")
public class ManagerController {

	@Autowired
	MstudentMapper mstudentMapper;
	@Autowired
	MteacherMapper mteacherMapper;
	@Autowired
	MclassMapper mclassMapper;
	@Autowired
	McollegeMapper mcollegeMapper;
	@Autowired
	MmajorMapper mmajorMapper;

	//查询学生所有的信息
	@GetMapping("/getstudent")
	public List<Student> sfind() {
		return mstudentMapper.findAll();
	}
	//根据学生id查询信息
	@GetMapping("/getstudent/{id}")
	public Student sload(@PathVariable BigInteger id) {
		return mstudentMapper.findById(id);
	}
	//添加学生信息
	@PostMapping("/add/student")
	public Student screate(@RequestBody Student student) {
		mstudentMapper.create(student);
		return student;
	}
	//安排学生班级
	@PutMapping("/arrange/student/{id}")
	public void update(@PathVariable BigInteger id,@RequestBody Student student) {
		student.setSid(id);
		mstudentMapper.update(student);
	}
		
	//查询老师所有信息
	@GetMapping("/getteacher")
	public List<Teacher> tfind() {
		return mteacherMapper.findAll();
	}
	//根据老师id查询信息
	@GetMapping("/getteacher/{id}")
	public Teacher tload(@PathVariable BigInteger id) {
		return mteacherMapper.findById(id);
	}
	//添加老师信息
	@PostMapping("/add/teacher")
	public Teacher tcreate(@RequestBody Teacher teacher) {
		mteacherMapper.create(teacher);
		return teacher;
	}
		
	//查询班级所有信息
	@GetMapping("/getclass")
	public List<Class> cfind() {
		return mclassMapper.findAll();
	}
	//根据班级id查询信息
	@GetMapping("/getclass/{id}")
	public Class cload(@PathVariable BigInteger id) {
		return mclassMapper.findById(id);
	}
	//安排老师班级
	@PostMapping("/arrange/teacher")
	public Class ccreate(@RequestBody Class class1) {
		mclassMapper.create(class1);
		return class1;
	}
		
	//根据学院id查询信息
	@GetMapping("/getcollege/{id}")
	public College coload(@PathVariable int id) {
		return mcollegeMapper.findById(id);
	}
	
	//查询学院所有信息
	@GetMapping("/getcollege")
	public List<College> cofind() {
		return mcollegeMapper.findAll();
	}
		
	//根据专业id查询信息
	@GetMapping("/getmload/{id}")
	public Major mload(@PathVariable int id) {
		return mmajorMapper.findById(id);
	}
	
	//查询所有信息
	@GetMapping("/getmload")
	public List<Major> mafind() {
		return mmajorMapper.findAll();
	}
}
