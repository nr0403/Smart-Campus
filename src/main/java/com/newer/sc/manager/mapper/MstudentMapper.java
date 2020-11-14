package com.newer.sc.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.College;
import com.newer.sc.common.entity.Major;
import com.newer.sc.common.entity.Student;

/**
 * 学生mapper
 * @author 介哥发财
 *
 */
@Mapper
public interface MstudentMapper {

	/**
	 * 修改学生信息
	 * @param student
	 */
	@Update("update students set sphone = #{sphone},spassword = #{spassword},s_cid=#{class1.cid},s_coid=#{college.coid},sgraduate=#{sgraduate},s_maid=#{major.maid} where sid = #{sid}")
	void update(Student student);
	
	
	/**
	 * 创建一个学生
	 * @param student
	 */
	@Insert("insert into students(sname,sphone,spassword,sbirthday,ssfz,s_cid,sgraduate,s_coid,s_maid)"
			+ " values(#{sname},#{sphone},#{spassword},#{sbirthday},#{ssfz},#{class1.cid},#{sgraduate},#{college.coid},#{major.maid})")
	void create (Student student);
	
	/**
	 * 根据id查询学生
	 * @param id
	 * @return
	 */
	@Select("select * from students where sid = #{id}")
	@Results(id="stuMap",value = {
			@Result(column = "s_cid",property = "class1",javaType =Class.class,one = @One(select = "com.newer.sc.manager.mapper.MclassMapper.findById")),
			@Result(column = "s_coid",property = "college",javaType =College.class,one = @One(select = "com.newer.sc.manager.mapper.McollegeMapper.findById")),
			@Result(column = "s_maid",property = "major",javaType =Major.class,one = @One(select = "com.newer.sc.manager.mapper.MmajorMapper.findById"))
    })
	Student findById(int id);
	
	/**
	 * 查询所有学生
	 * @return
	 */
	@Select("select * from students")
	@ResultMap(value="stuMap")
	List<Student> findAll();
	
	
	
	
}
