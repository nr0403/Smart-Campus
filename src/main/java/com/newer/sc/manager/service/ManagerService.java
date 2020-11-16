package com.newer.sc.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.College;
import com.newer.sc.common.entity.Major;
import com.newer.sc.manager.mapper.ManageMapper;

/**
 * 教务服务层
 * @author Amichen
 *
 */
@Service
public class ManagerService {
  
	@Autowired
	ManageMapper studentMapper;
	
	/**
	 * 查所有学院
	 * @return
	 */
	public List<College> findAllCo() {
		return studentMapper.findAllCo();
	}
	
	/**
	 * 根据学院名查专业
	 * @param name
	 * @return
	 */
	public List<Major> findMajorsByCo(String name){
		return studentMapper.findMaByCo(name);
	}
	
	/**
	 * 根据专业名查班级
	 * @param majorName
	 * @return
	 */
	public List<Class> findClassesByMajor(String majorName){
		return studentMapper.findClassesByMajor(majorName);
	}
	
	/**
	 * 根据专业id查班级
	 * @param maid
	 * @return
	 */
	public List<Class> findClassesByMajorId(int maid){
		return studentMapper.findClassesByMajorId(maid);
	}
	
}
