package com.newer.sc.manager.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.College;
import com.newer.sc.common.entity.Major;
import com.newer.sc.common.entity.Student;
import com.newer.sc.common.entity.Teacher;

/**
 * 老师mapper
 * @author 介哥发财
 *
 */
@Mapper
public interface MteacherMapper {
	
	/**
	 * 创建一个老师
	 * @param student
	 */
	@Insert("insert into teacher(tname,tpassword,tphone,tsfz,tbirthday,tlevel,t_coid)"
			+ " values(#{tname},#{tpassword},#{tphone},#{tsfz},#{tbirthday},#{tlevel},#{college.coid})")
	void create (Teacher teacher);

	/**
	 * 根据id查询老师
	 * @param id
	 * @return
	 */
	@Select("select * from teacher where tid = #{id}")
	@Results(id="teacherMap",value = {
			@Result(column = "t_coid",property = "college",javaType =College.class,one = @One(select = "com.newer.sc.manager.mapper.McollegeMapper.findById")),
			})
	Teacher findById(int id);
	
	/**
	 * 查询所有老师信息
	 * @return
	 */
	@Select("select * from teacher")
	@ResultMap(value="teacherMap")
	List<Teacher> findAll();
}
