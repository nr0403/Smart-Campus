package com.newer.sc.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.sc.manager.mapper.ExamMapper;

/**
 * 考试服务层
 * @author Amichen
 *
 */
@Service
public class ExamService {
	
	@Autowired
	ExamMapper examMapper;
	
	
	
}
