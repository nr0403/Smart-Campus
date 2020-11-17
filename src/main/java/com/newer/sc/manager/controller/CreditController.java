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

import com.newer.sc.common.entity.Credit;
import com.newer.sc.manager.mapper.CreditMapper;

/**
 * 学分控制器
 * @author Amichen
 *
 */
@RestController
@RequestMapping("/admin/credit")
public class CreditController {
	
	@Autowired
	CreditMapper creditMapper;
	
	/**
	 * 查看所有学分项
	 * @return
	 */
	@GetMapping()
	List<Credit> findAll(){
		return creditMapper.findAll();
	}
	
	/**
	 * 根据学生id查询个人学分完成项
	 * @param sid
	 * @return
	 */
	@GetMapping("/student/{sid}")
	List<Credit> findCreditsByStu(@PathVariable int sid){
		return creditMapper.findCreditsByStu(sid);
	}
	
	/**
	 * 获取指定id的学生的学分统计
	 * @param sid
	 * @return
	 */
	@GetMapping("/sum/{sid}")
	int getSum(@PathVariable int sid){
		return creditMapper.sumCredit(sid);
	}
	
	/**
	 * 更新学分项
	 * @param credit
	 */
	@PutMapping()
	void updateCredit(@RequestBody Credit credit) {
		creditMapper.update(credit);
	}
	
	
	/**
	 * 添加学分项
	 * @param credit
	 */
	@PostMapping()
	void addCredit(@RequestBody Credit credit) {
		creditMapper.addCredit(credit);
	}

	
}
