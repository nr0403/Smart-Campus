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

import com.newer.sc.common.entity.Exam;
import com.newer.sc.manager.mapper.ExamMapper;

/**
 * 考试控制层
 * @author Amichen
 *
 */
@RestController
@RequestMapping("/admin/exam")
public class ExamController {
	
	@Autowired
	ExamMapper examMapper;
	
	/**
	 * 查看所有考试安排
	 * @return
	 */
	@GetMapping
	public List<Exam> findAll() {
		return examMapper.findAllExam();
	}
	
	/**
	 * 根据id查询考试安排
	 * @param eid
	 * @return
	 */
	@GetMapping("/{eid}")
	public List<Exam> findExamsByStu(@PathVariable int eid){
		return examMapper.findExamsById(eid);
	}
	
	/**
	 * 根据班级查询考试安排
	 * @param cid
	 * @return
	 */
	@GetMapping("/class/{cid}")
	public List<Exam> findExamsByClass(@PathVariable int cid){
		return examMapper.findExamsByClass(cid);
	}
	
	/**
	 * 安排新的考试
	 * @param exam
	 */
	@PostMapping()
	public void addExam(@RequestBody Exam exam) {
		examMapper.addExam(exam);
	}
	
	/**
	 * 修改考试
	 * @param exam
	 */
	@PutMapping()
	public void updateExam(@RequestBody Exam exam) {
		examMapper.updateExam(exam);
	}
 
}
