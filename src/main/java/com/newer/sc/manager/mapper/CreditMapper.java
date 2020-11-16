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

import com.newer.sc.common.entity.Check;
import com.newer.sc.common.entity.Credit;
import com.newer.sc.common.entity.Grade;
import com.newer.sc.common.entity.Student;

/**
 * 学分持久化接口
 * @author Amichen
 *
 */
@Mapper
public interface CreditMapper {
	
	/**
	 * 查看所有学分项
	 * @return
	 */
	@Select("select * from credit")
	@Results(id = "creditMap",value = {
			@Result(column = "cr_sid",property = "student",javaType =Student.class,one = @One(select = "com.newer.sc.manager.mapper.MstudentMapper.findById")),
			@Result(column = "cr_gid",property = "grade",javaType = Grade.class,one = @One(select = "com.newer.sc.manager.mapper.ManageMapper.findGrade")),
			@Result(column = "cr_chid",property = "check",javaType = Check.class,one = @One(select = "com.newer.sc.manager.mapper.ManageMapper.findCheck"))
    })
	List<Credit> findAll();
	
	/**
	 * 根据学生id查询个人学分完成项
	 * @param sid
	 * @return
	 */
	@Select("select * from credit where cr_sid = #{sid}")
	@ResultMap(value = "creditMap")
	List<Credit> findCreditsByStu(int sid);
	
	/**
	 * 获取指定id的学分获取的总学分
	 * @param sid
	 * @return
	 */
	@Select("select sum(crhour) from credit where cr_sid =#{sid}")
	int sumCredit(int sid);
	
	/**
	 * 更新学分表
	 * @param credit
	 */
	@Update("update credit set cr_gid=#{grade.gid},cr_chid=#{check.chid},cr_sid=#{student.sid},crhour=#{crhour} where crid=#{crid}")
	void update(Credit credit);
	
	/**
	 * 添加学分项
	 * @param credit
	 */
	@Options(useGeneratedKeys = true,keyColumn = "crid",keyProperty = "crid")
	@Insert("insert into credit (cr_gid,cr_chid,cr_sid,crhour)"
			+ " values (#{grade.gid},#{check.chid},#{student.sid},#{crhour})")
	void addCredit(Credit credit);
	
	
}
