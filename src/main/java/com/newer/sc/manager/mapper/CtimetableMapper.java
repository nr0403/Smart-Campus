package com.newer.sc.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.Ctimetable;
import com.newer.sc.common.entity.Teacher;

/**
 * 课表持久化接口
 * @author Amichen
 *
 */
@Mapper
public interface CtimetableMapper {
	
	/**
	 * 查看所有课表
	 * @return
	 */
	@Results(id = "kbMap",value = {
			@Result(column = "ct_cid",property = "class1",javaType =Class.class,one = @One(select = "com.newer.sc.manager.mapper.MclassMapper.findById")),
			@Result(column = "ct_tid",property = "teacher",javaType =Teacher.class,one = @One(select = "com.newer.sc.manager.mapper.MteacherMapper.findById"))
    })
	@Select("select * from ctimetable")
	List<Ctimetable> findAll();
	
	/**
	 * 根据班级id查看班级课表
	 * @param cid
	 * @return
	 */
	@ResultMap(value = "kbMap")
	@Select("select * from ctimetable where ct_cid = #{cid}")
	List<Ctimetable> findCtimetablesByClass(int cid);
	
	/**
	 * 根据教师id 查看老师课表
	 * @param tid
	 * @return
	 */
	@ResultMap(value = "kbMap")
	@Select("select * from ctimetable where ct_tid = #{tid}")
	List<Ctimetable> findCtimetablesByTeacher(int tid);
	
	/**
	 * 添加课表
	 * @param ctimetable
	 */
	@Options(useGeneratedKeys = true,keyColumn = "ctid",keyProperty = "ctid")
	@Insert("insert into ctimetable (ctname,ct_cid,ct_tid,ctweek,cttime,ctcycle)"
			+ " values (#{ctname},#{class1.cid},#{teacher.tid},#{ctweek},#{cttime},#{ctcycle})")
	void addCtimetable(Ctimetable ctimetable);
	
	/**
	 * 修改课表 调课
	 * @param ctimetable         
	 */
	@Update("update ctimetable set ctname=#{ctname},ct_cid=#{class1.cid},ct_tid=#{teacher.tid},ctweek=#{ctweek},cttime=#{cttime},ctcycle=#{ctcycle} where ctid=#{ctid}")
	void updateCtimetable(Ctimetable ctimetable);
	
}
