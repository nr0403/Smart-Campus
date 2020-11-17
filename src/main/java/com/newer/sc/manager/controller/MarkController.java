package com.newer.sc.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.sc.common.entity.Mark;
import com.newer.sc.manager.mapper.MarkMapper;

/**
 * 教学评分控制器
 * @author Amichen
 *
 */
@RestController
@RequestMapping("admin/mark")
public class MarkController {
	
	@Autowired
	MarkMapper markMapper;
	
	/**
	 * 查所有评分
	 * @return
	 */
	@GetMapping
	public List<Mark> findAllMark() {
		return markMapper.findAllMarks();
	}
	
	/**
	 * 根据老师名查评分
	 * @param tname
	 * @return
	 */
	@GetMapping("/teacher")
	public List<Mark> findMarksByTname(@RequestParam String tname){
		return markMapper.findMarksByTname(tname);
	}
	
}
