package com.newer.sc.teacher.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestBody;

import com.newer.sc.common.entity.Check;
import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.College;
import com.newer.sc.common.entity.Ctimetable;
import com.newer.sc.common.entity.Grade;
import com.newer.sc.common.entity.Major;
import com.newer.sc.common.entity.Student;
import com.newer.sc.common.entity.Teacher;

/**
 * mapper(连接数据库,执行sql语句,返回结果)
 * @author May3rd
 *
 */
@Mapper
public interface TchMapper {
	
	/**
	 * 查询课表
	 */
	@Select("SELECT * FROM ctimetable WHERE ct_tid=#{id}")
	@Result(column = "ct_tid",property ="teacher",one = @One(select = "findById"))
	@Result(column = "ct_cid",property ="class1",one = @One(select = "findClzById"))
	List<Ctimetable> findTimeById(int id);
	
	
	/**
	 * 查询班级花名册
	 */
	@Select("SELECT * FROM students WHERE s_cid=#{id}")
	@Result(column = "s_cid",property ="class1",one = @One(select = "findClzById"))
	@Result(column = "s_coid",property = "college",one = @One(select = "findCoByTid"))
	@Result(column = "s_maid",property ="major",one = @One(select = "findMaById"))
	List<Student> findAllStuByClzId(int id);
	
	/**
	 * 创建学生成绩
	 */
	@Options(
			useGeneratedKeys = true,
			keyColumn = "gid",
			keyProperty = "gid"
			)
	@Insert("INSERT INTO grade(g_sid,gscore,g_eid,g_ccid) VALUES(#{student.sid},#{gscore},#{exam.eid},#{ccie.ccid})")
	void createGrade(Grade grade);
	
	/**
	 * 修改学生成绩
	 */
	@Update("update grade set gscore=#{gscore},g_eid=#{exam.eid},g_ccid=#{ccie.ccid} where g_sid=#{student.sid}")
	void updateGrade(Grade grade);
	
	/**
	 * 提交学生考勤
	 */
	@Insert("INSERT INTO `CHECK`(ch_sid,chdate,chstate,ch_ctid) VALUES(#{student.sid},#{chdate},#{chstate},#{ctimetable.ctid})")
	void createCheck(Check check);
	
	/**
	 * -----------------------------------------------------------------------------------------------------------------
	 * 查询老师所属学院
	 */
	@Select("SELECT * FROM college WHERE coid=#{id}")
	College findCoByTid(int id);
	
	/**
	 * 查询老师个人信息
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM teacher WHERE tid=#{id}")
	@Result(column = "t_coid",property = "college",one = @One(select = "findCoByTid"))
	Teacher findById(int id);
	
	/**
	 * 查询班级
	 */
	@Select("SELECT * FROM class WHERE cid=#{id}")
	@Result(column = "c_tid",property ="teacher",one = @One(select = "findById"))
	@Result(column = "c_maid",property ="major",one = @One(select = "findMaById"))
	Class findClzById(int id);
	
	/**
	 * 查询专业
	 */
	@Select("SELECT * FROM major WHERE maid=#{id}")
	@Result(column = "ma_coid",property = "college",one = @One(select = "findCoByTid"))
	Major findMaById(int id);
	
	//-------------------------------------------------------------------------------------------------------------------
	
	
}
