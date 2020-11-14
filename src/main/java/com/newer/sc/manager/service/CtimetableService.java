package com.newer.sc.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.sc.manager.mapper.CtimetableMapper;

/**
 * 
 * @author Amichen
 *
 */
@Service
public class CtimetableService {
	
	@Autowired
	CtimetableMapper ctimetableMapper;

}
