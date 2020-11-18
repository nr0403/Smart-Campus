package com.newer.sc.student.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.sc.common.entity.Student;
import com.newer.sc.common.entity.Teacher;
import com.newer.sc.common.entity.Ccie;
import com.newer.sc.common.entity.CcieStu;
import com.newer.sc.common.entity.Check;
import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.College;
import com.newer.sc.common.entity.Course;
import com.newer.sc.common.entity.Credit;
import com.newer.sc.common.entity.Ctimetable;
import com.newer.sc.common.entity.Ele_Stu;
import com.newer.sc.common.entity.Elective;
import com.newer.sc.common.entity.Exam;
import com.newer.sc.common.entity.ExamStu;
import com.newer.sc.common.entity.Grade;
import com.newer.sc.common.entity.Major;

@Mapper
public interface studentMapper {
//	查询学生所有信息
	@Select("select * from students where sid=#{id}")
	@Results(id = "student", value = {
			@Result(column = "s_cid", property = "class1", one = @One(select = "findClassById")),
			@Result(column = "s_coid", property = "college", one = @One(select = "findCollege")),
			@Result(column = "s_maid",property = "major",one = @One(select = "findMajor"))})
	public Student findByid(BigInteger id);

//	查询班级
	@Select("select * from class where cid=#{id}")
	@Results(id = "findClass", value = {
			@Result(column = "c_maid", property = "major", one = @One(select = "findMajor")) })
	public Class findStudentClass(BigInteger id);

//	查询学院
	@Select("select * from college where coid=#{id}")
	@Results(id = "findCollege", value = {
	})
	public College findCollege(int id);

//	通过转专业id查专业
	@Select("select *  from Major where maid=#{id}")
	@Results(id = "findMajor", value = {
			@Result(column = "ma_coid",property = "college",one = @One(select = "findCollege"))
	})
	public Major findMajor(int id);
	
//	查看学生所在专业
	@Select("select * from major where maid=#{id}")
	public Major findMajorByStudent(int id);

//	查看班级考试安排
	@Select("select * from exam where e_cid=#{id}")
	@Results(value = {
			@Result(column ="e_cid",property = "class1", one = @One(select = "findClassById")),
			@Result(column = "e_couid",property = "course",one = @One(select = "findCourseById"))
			
	})
	public List<Exam> findByStudentClass(Integer cid);
	
//	通过班级ID查班级信息
	@Select("select * from class where cid=#{id}")
	@Results(value = {
			@Result(column = "c_maid",property = "major",one = @One(select = "findMajor")),
			@Result(column = "c_tid",property = "teacher",one = @One(select = "findTeacherById"))
	})
	public Class findClassById(int id);
	
//	通过课程id查课程
	@Select("select * from course where couid=#{id}")
	public Course findCourseById(int id);
	
//	查询班级的课表
	@Select("select * from ctimetable where ct_cid=#{id}")
	@Results(
			value = {
					@Result(column = "ct_cid",property = "class1",one = @One(select = "findClassById")),
					@Result(column = "ct_tid",property = "teacher",one = @One(select = "findTeacherById"))
			})
	public List<Ctimetable> findCtimeTableByClassId(Integer cid);
	
//	通过老师id查老师
	@Select("select * from teacher where tid=#{id}")
	@Results(value = {
			@Result(column = "t_coid",property = "college",one = @One(select = "findCollege"))
	})
	public Teacher findTeacherById(BigInteger id);
	
	
//	查询学分
	@Select("select * from credit where cr_sid=#{id}")
	  @Results(value = {
	      @Result(column = "cr_gid",property = "grade",one = @One(select = "findGrade")),
	      @Result(column = "cr_sid",property = "student",one = @One(select = "findByid"))
	  })
	  public Credit findCreditById(BigInteger sid);
	
//	查询分数
	@Select("select * from grade where g_sid=#{id}")
	@Results(value = {
			@Result(column = "g_sid",property = "student",one = @One(select = "findByid")),
			@Result(column = "g_eid",property = "exam",one = @One(select = "findExam"))
	})
	public List<Grade> findGrade(BigInteger id);
	
//	通过考试id查考试信息
	@Select("select * from exam where eid=#{id}")
	public Exam findExam(int id);
	
//	通过学生id查考勤信息
	@Select("select * from `check` where ch_sid=#{id}")
	public List<Check> findCheck(BigInteger sid);
	
//	学生申请奖学金
	@Insert("insert into bursary(b_sid,b_crid) values (#{sid},#{credit})")
	public void insertBursary(BigInteger sid,int credit);
	
	
//	查询所有等级考试信息
	@Select("select * from ccie")
	public List<Ccie> findAllCcie();
	
//	学生报名登记考试
	@Insert("insert into ccie_student(sc_cid,sc_sid) values (#{cid},#{id})")
	public void insertCcie(int cid,BigInteger id);
	
//	查询所有选修课
	@Select("select * from elective")
	public List<Elective> findAllEle();
	
//	学生报名选修课
	@Insert("insert into ele_sut(eles_sid,eles_elid) values (#{eid},#{id})")
	public void insertEle(int eid,BigInteger id);
	
//	查询所有老师
	@Select("select * from teacher")
	@Results(value = {
			@Result(column = "t_coid",property = "college",one = @One(select = "findCollege"))
	})
	public List<Teacher> findAllTea();
	
//	学生给老师评分
	@Insert("insert into mark(m_tid,mscore) values (#{tid},#{score})")
	public void insertMark(int tid,int score);
	
//	学生申请补考
	@Insert("insert into exam_stu(es_sid,es_eid,estate) values (#{sid},#{eid},1)")
	public void insertExam(BigInteger sid,int eid);
	
//  查询已申请补考
	@Select("select * from exam_stu where es_eid=#{id} and estate=1")
	@Results(value = {
			@Result(column = "es_eid",property = "exam" ,one = @One(select = "findExam")),
			@Result(column = "es_sid",property = "student",one = @One(select = "findByid"))
	})
	public List<ExamStu> findExamBysid(BigInteger id);
	
//	通过证书id查证书信息
	@Select("select * from ccie where ccid=#{id}")
	public Ccie findCcieById(int id);
	
//	查询已申请的证书考试
	@Select("select * from ccie_student where sc_sid=#{id}")
	@Results(value = {
			@Result(column = "sc_cid",property = "ccie",one = @One(select = "findCcieById")),
			@Result(column = "cs_sid",property = "student",one = @One(select = "findByid"))
	})
	public List<CcieStu> findCcieBySid(BigInteger id);
	
	//通过选修课id查选修课
	@Select("select * from elective where elid=#{id}")
	public Elective findEleByid(int id);
	
//	查看已申请的选修课
	@Select("select * from ele_sut where eles_sid=#{id}")
	@Results(value = {
			@Result(column = "eles_elid",property = "elective",one = @One(select = "findEleByid"))
	})
	public List<Ele_Stu> findEleStu(BigInteger id);
	
//	学生修改个人信息
	@Update("update students set sname=#{sname},sphone=#{sphone},ssfz=#{ssfz} where sid=#{sid}")
	public void updateStu(Student stu);
	
	
	//学生修改密码
	@Update("update Students set spassword=#{pass} where sid=#{sid}")
	public void UpStu(BigInteger sid,String pass);
}
