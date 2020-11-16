package com.newer.sc.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.College;
import com.newer.sc.common.entity.Course;
import com.newer.sc.common.entity.Major;
import com.newer.sc.common.entity.Student;
import com.newer.sc.manager.mapper.ManageMapper;
import com.newer.sc.manager.service.ManagerService;

/**
 * 学院专业控制器
 * @author Amichen
 *
 */
@RestController
@RequestMapping("/admin")
public class CollegeController {
	
	@Autowired
	ManagerService managerService;
	
	@Autowired
	ManageMapper manageMapper;
	
	/**
	 * 所有学院
	 * @return
	 */
	@GetMapping("/college")
	public List<College> findColleges(){
		return managerService.findAllCo();
	}
	
	/**
	 * 根据学院名查专业
	 * @param name
	 * @return
	 */
	@GetMapping("/major/co")
	public List<Major> findMajorsByCo(@RequestParam String name){
		return managerService.findMajorsByCo(name);
	}
	
	/**
	 * 根据专业名查班级
	 * @param majorName
	 * @return
	 */
	@GetMapping("/class/ma")
	public List<Class> findClassesByMajor(@RequestParam String majorName){
		return managerService.findClassesByMajor(majorName);
	}
	
	/**
	 * 根据专业id查班级
	 * @param maid
	 * @return
	 */
	@GetMapping("/class/ma/{maid}")
	public List<Class> findClassesByMajorId(@PathVariable int maid){
		return managerService.findClassesByMajorId(maid);
	}
	
	/**
	 * 根据课程id查询
	 * @param couid
	 * @return
	 */
	@GetMapping("/course/{couid}")
	public Course findCourseByid(@PathVariable int couid) {
		return manageMapper.findCourseById(couid);
	}
	
	/**
	 * 查询所有课程
	 * @return
	 */
	@GetMapping("/course")
	public List<Course> findCourses(){
		return manageMapper.findAllCourse();
	}
	
	/**
	 * 按名字查询课程
	 * @param couname
	 * @return
	 */
	@GetMapping("/course/co")
	public Course findCourseByName(@RequestParam String couname) {
		return manageMapper.findCourseByName(couname);
	}
	
	/**
	 * 添加课程
	 * @param course
	 */
	@PostMapping("/course")
	public void addCourse(@RequestBody Course course) {
		manageMapper.addCourse(course);
	}
	
	/**
	 * 修改课程
	 * @param course
	 */
	@PutMapping("/course")
	public void updateCourse(@RequestBody Course course) {
		manageMapper.updateCourse(course);
	}
	
	/**
	 * 根据班级id查班内所有学生
	 * @param cid
	 * @return
	 */
	@GetMapping("/student/class/{cid}")
	public List<Student> findByClassId(@PathVariable int cid){
		return manageMapper.findByClassId(cid);
	}
	
	/**
	 * 根据班级名查班内所有学生
	 * @param cname
	 * @return
	 */
	@GetMapping("/student/class")
	public List<Student > findByClassName(@RequestParam String cname){
		return manageMapper.findByClassName(cname);
	}
	
}
