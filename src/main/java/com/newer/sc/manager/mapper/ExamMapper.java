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
import com.newer.sc.common.entity.Course;
import com.newer.sc.common.entity.Exam;

/**
 * 考试持久化接口
 * @author Amichen
 *
 */
@Mapper
public interface ExamMapper {
	
	/**
	 * 查看所有考试安排
	 * @return
	 */
	@Results(id = "examMap",value = {
			@Result(column = "e_cid",property = "class1",javaType =Class.class,one = @One(select = "com.newer.sc.manager.mapper.MclassMapper.findById")),
			@Result(column = "e_couid",property = "course",javaType =Course.class,one = @One(select = "com.newer.sc.manager.mapper.ManageMapper.findCourseById"))
    })
	@Select("select * from exam")
	List<Exam> findAllExam();
	
	/**
	 * 根据id查询考试
	 * @param sid
	 * @return
	 */
	@ResultMap(value = "examMap")
	@Select("select * from exam where eid = #{eid}")
	List<Exam> findExamsById(int eid);	
 	
	/**
	 * 根据班级查询考试安排
	 * @param cid
	 * @return
	 */
	@ResultMap(value = "examMap")
	@Select("select * from exam where e_cid = #{cid} ")
	List<Exam> findExamsByClass(int cid);
	
	
	/**
	 * 安排新的考试
	 * @param exam
	 */
	@Options(useGeneratedKeys = true,keyColumn = "eid",keyProperty = "eid")
	@Insert("insert into exam (ename,etime,eaddress,e_cid,e_couid,estate)"
			+ " values (#{ename},#{etime},#{eaddress},#{class1.cid},#{course.couid},#{estate})")
	void addExam(Exam exam);
	
	/**
	 * 更新考试
	 * @param exam
	 */
	@Update("update exam set ename=#{ename},etime=#{etime},eaddress=#{eaddress},e_cid=#{class1.cid},e_couid=#{course.couid},estate=#{estate} where eid=#{eid}")
	void updateExam(Exam exam);
	
}
