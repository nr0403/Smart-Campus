package com.newer.sc.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.Exam;
import com.newer.sc.common.entity.Student;

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
	@Results(value = {
			@Result(column = "e_cid",property = "class1",javaType =Class.class,one = @One(select = "com.newer.sc.manager.mapper.MclassMapper.findById")),
			@Result(column = "e_sid",property = "student",javaType =Student.class,one = @One(select = "com.newer.sc.manager.mapper.MstudentMapper.findById"))
    })
	@Select("select * from exam")
	List<Exam> findAllExam();
	
	/**
	 * 根据学生查询个人考试安排
	 * @param sid
	 * @return
	 */
	@Results(value = {
			@Result(column = "e_sid",property = "student",javaType =Student.class,one = @One(select = "com.newer.sc.manager.mapper.MstudentMapper.findById"))
    })
	@Select("select * from exam where e_sid = #{sid}")
	List<Exam> findExamsByStu(int sid);
 	
	/**
	 * 根据班级查询考试安排
	 * @param cid
	 * @return
	 */
	@Results(value = {
			@Result(column = "e_sid",property = "student",javaType =Student.class,one = @One(select = "com.newer.sc.manager.mapper.MstudentMapper.findById"))
    })
	@Select("select * from exam where e_cid = #{cid} ")
	List<Exam> findExamsByClass(int cid);
	
	/**
	 * 安排新的考试
	 * @param exam
	 */
	@Options(useGeneratedKeys = true,keyColumn = "eid",keyProperty = "eid")
	@Insert("insert into exam (ename,etime,eaddress,e_cid,e_couid,estate,e_sid)"
			+ " values (#{ename},#{etime},#{eaddress},#{class1.cid},#{course.couid},#{estate},#{student.sid})")
	void addExam(Exam exam);
	
}
