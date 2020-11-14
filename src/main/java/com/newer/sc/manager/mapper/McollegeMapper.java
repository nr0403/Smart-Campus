package com.newer.sc.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.newer.sc.common.entity.College;

/**
 * 学院mapper
 * @author 介哥发财
 *
 */
@Mapper
public interface McollegeMapper {

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from college where coid = #{id}")
	College findById(int id);
	
	/**
	 * 查询所有学院
	 * @return
	 */
	@Select("select * from college")
	List<College> findAll();
}
