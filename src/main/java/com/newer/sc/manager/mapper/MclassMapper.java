package com.newer.sc.manager.mapper;

import java.math.BigInteger;
import java.util.List;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.Major;
import com.newer.sc.common.entity.Teacher;

/**
 * 班级mapper
 * @author 介哥发财
 *
 */
@Mapper
public interface MclassMapper {

	/**
	 * 创建班级（指定老师）
	 * @param student
	 */
	@Insert("insert into class(cname,c_tid,c_maid,ctime)"
			+ " values(#{cname},#{teacher.tid},#{major.maid},#{ctime})")
	void create (Class class1);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from class where cid = #{id}")
	@Results(id="classMap",value = {
			@Result(column = "c_tid",property = "teacher",javaType =Teacher.class,one = @One(select = "com.newer.sc.manager.mapper.MteacherMapper.findById")),
			@Result(column = "c_maid",property = "major",javaType =Major.class,one = @One(select = "com.newer.sc.manager.mapper.MmajorMapper.findById"))
			})
	Class findById(BigInteger id);
	
	/**
	 * 查询所有班级信息
	 * @return
	 */
	@Select("select * from class")
	@ResultMap(value="classMap")
	List<Class> findAll();
}
