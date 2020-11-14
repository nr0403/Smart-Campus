package com.newer.sc.manager.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newer.sc.common.entity.College;
import com.newer.sc.common.entity.Major;

/**
 * 专业mapper
 * @author 介哥发财
 *
 */
@Mapper
public interface MmajorMapper {

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from major where maid = #{id}")
	@Results(id="majorMap",value = {
			@Result(column = "ma_coid",property = "college",javaType =College.class,one = @One(select = "com.newer.sc.manager.mapper.McollegeMapper.findById")),
			})
	Major findById(int id);
}
