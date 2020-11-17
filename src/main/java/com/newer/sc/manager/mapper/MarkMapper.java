package com.newer.sc.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newer.sc.common.entity.Mark;
import com.newer.sc.common.entity.Teacher;

/**
 * 教学评分
 * @author Amichen
 *
 */
@Mapper
public interface MarkMapper {
	
	@Select("select * from mark")
	@Results(id = "markMap",value = {
			@Result(column = "m_tid",property = "teacher",javaType =Teacher.class,one = @One(select = "com.newer.sc.manager.mapper.MteacherMapper.findById"))
	})
	List<Mark> findAllMarks();
	
	@Select("select * from mark inner join teacher on mark.m_tid = teacher.tid ")
	@ResultMap(value = "markMap")
	List<Mark> findMarksByTname(String tname);

}
