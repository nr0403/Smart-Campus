package com.newer.sc.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.sc.common.entity.Ctimetable;
import com.newer.sc.manager.mapper.CtimetableMapper;

/**
 * 课表控制器
 * @author Amichen
 *
 */
@RestController
@RequestMapping("/admin/ctimetable")
public class CtimetableController {
	
	@Autowired
	CtimetableMapper ctimetableMapper;
	
	/**
	 * 查看所有课表
	 * @return
	 */
	@GetMapping()
	List<Ctimetable> findAll(){
		return ctimetableMapper.findAll();
	}
	
	/**
	 * 根据班级id查看班级课表
	 * @param cid
	 * @return
	 */
	@GetMapping("/class/{cid}")
	List<Ctimetable> findCtimetablesByClass(@PathVariable int cid){
		return ctimetableMapper.findCtimetablesByClass(cid);
	}
	
	/**
	 * 根据教师id查看教师课表
	 * @param tid
	 * @return
	 */
	@GetMapping("/teacher/{tid}")
	List<Ctimetable> findCtimetablesByTeacher(@PathVariable int tid){
		return ctimetableMapper.findCtimetablesByTeacher(tid);
	}
	
	
	/**
	 * 添加课表
	 * @param ctimetable
	 */
	@PostMapping()
	void addCtimetable(@RequestBody Ctimetable ctimetable) {
		ctimetableMapper.addCtimetable(ctimetable);
	}
	
	/**
	 * 修改课表 调课
	 * @param ctimetable
	 */
	@PutMapping
	void updateCtimetable(@RequestBody Ctimetable ctimetable) {
		ctimetableMapper.updateCtimetable(ctimetable);
	}
	
}
