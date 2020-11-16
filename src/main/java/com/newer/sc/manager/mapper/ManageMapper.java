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

import com.newer.sc.common.entity.Student;
import com.newer.sc.common.entity.Teacher;
import com.newer.sc.common.entity.Ccie;
import com.newer.sc.common.entity.Check;
import com.newer.sc.common.entity.Class;
import com.newer.sc.common.entity.College;
import com.newer.sc.common.entity.Course;
import com.newer.sc.common.entity.Credit;
import com.newer.sc.common.entity.Ctimetable;
import com.newer.sc.common.entity.Elective;
import com.newer.sc.common.entity.Exam;
import com.newer.sc.common.entity.Grade;
import com.newer.sc.common.entity.Major;

@Mapper
public interface ManageMapper {
//	查询学生所有信息
	@Select("select * from students where sid=#{id}")
	@Results(id = "student", value = {
			@Result(column = "s_cid", property = "class1", one = @One(select = "findClassById")),
			@Result(column = "s_coid", property = "college", one = @One(select = "findCollege")),
			@Result(column = "s_maid",property = "major",one = @One(select = "findMajor"))})
	public Student findByid(int id);
	
//	根据班级名查班内所有学生
	@Select("SELECT * FROM `students` INNER JOIN class on students.s_cid = class.cid where class.cname = #{cname}")
	@ResultMap(value = "student")
	public List<Student> findByClassName(String cname);
	
	
//	根据班级id查班内所有学生
	@Select("SELECT * FROM `students` INNER JOIN class on students.s_cid = class.cid where class.cid = #{cid}")
	@ResultMap(value = "student")
	public List<Student> findByClassId(int cid);

//	查询班级
	@Select("select * from class where cid=#{id}")
	@Results(id = "findClass", value = {
			@Result(column = "c_maid", property = "major", one = @One(select = "findMajor")) })
	public Class findStudentClass(int id);

//	查询学院
	@Select("select * from college where coid=#{id}")
	@Results(id = "findCollege", value = {
	})
	public College findCollege(int id);
	
// 查询所有学院
	@Select("select * from college")
	List<College> findAllCo();
	
	
//	通过专业id查专业
	@Select("select *  from Major where maid=#{id}")
	@Results(id = "findMajor", value = {
			@Result(column = "ma_coid",property = "college",one = @One(select = "findCollege"))
	})
	public Major findMajor(int id);
	
//	根据学院名查专业
	@Select("select m.maid,m.maname,m.ma_coid from major m INNER JOIN college co on m.ma_coid = co.coid WHERE co.coname = #{coname} ")
	@ResultMap(value = "findMajor")
	List<Major> findMaByCo(String coname);
	
	
////	查看学生所在专业
//	@Select("select * from major where maid=#{id}")
//	public Major findMajorByStudent(int id);

//	查看班级考试安排
	@Select("select * from exam where e_cid=#{id}")
	@Results(value = {
			@Result(column ="e_cid",property = "class1", one = @One(select = "findClassById")),
			@Result(column = "e_couid",property = "course",one = @One(select = "findCourseById"))
			
	})
	public List<Exam> findByStudentClass(int id);
	
//	通过班级ID查班级信息
	@Select("select * from class where cid=#{id}")
	@Results(id = "classMap",value = {
			@Result(column = "c_maid",property = "major",one = @One(select = "findMajor")),
			@Result(column = "c_tid",property = "teacher",one = @One(select = "findTeacherById"))
	})
	public Class findClassById(int id);
	
	
	// 根据专业名查班级
	@Select("select * from class inner join major on class.c_maid = major.maid where major.maname = #{majorName}")
	@ResultMap(value = "classMap")
	public List<Class> findClassesByMajor(String majorName);
	
	// 根据专业id查班级
	@Select("select * from class inner join major on class.c_maid = major.maid where major.maid = #{maid}")
	@ResultMap(value = "classMap")
	public List<Class> findClassesByMajorId(int maid);
	
	
//	通过课程id查课程
	@Select("select * from course where couid=#{id}")
	public Course findCourseById(int id);
	
//  查所有课程
	@Select("select * from course")
	public List<Course> findAllCourse();

//  通过课程名查课程
	@Select("select * from course where couname = #{couname}")
	public Course findCourseByName(String couname);
	
// 	添加课程
	@Insert("insert into course (couname,cougrade,coujc,couhour) values (#{couname},#{cougrade},#{coujc},#{couhour})")
	public void addCourse(Course course);

//	修改课程
	@Update("update course set couname=#{couname} ,cougrade=#{cougrade},coujc=#{coujc},couhour=#{couhour} where couid=#{couid}")
	public void updateCourse(Course course);
	
//	查询班级的课表
	@Select("select * from ctimetable where ct_cid=#{id}")
	@Results(
			value = {
					@Result(column = "ct_cid",property = "class1",one = @One(select = "findClassById")),
					@Result(column = "ct_tid",property = "teacher",one = @One(select = "findTeacherById"))
			})
	public List<Ctimetable> findCtimeTableByClassId(int id);
	
//	通过老师id查老师
	@Select("select * from teacher where tid=#{id}")
	@Results(value = {
			@Result(column = "t_coid",property = "college",one = @One(select = "findCollege"))
	})
	public Teacher findTeacherById(int id);
	
	
//	查询学分
	@Select("select * from credit where crid=#{id}")
	@Results(value = {
			@Result(column = "cr_gid",property = "grade",one = @One(select = "findGrade"))
	})
	public Credit findCreditById(int sid);
	
//	查询分数
	@Select("select * from grade where g_sid=#{id}")
	@Results(value = {
			@Result(column = "g_sid",property = "student",one = @One(select = "findByid")),
			@Result(column = "g_eid",property = "exam",one = @One(select = "findExam"))
	})
	public List<Grade> findGrade(int id);
	
//	通过考试id查考试信息
	@Select("select * from exam where eid=#{id}")
	public Exam findExam(int id);
	
//	通过学生id查考勤信息
	@Select("select * from `check` where ch_sid=#{id}")
	public List<Check> findCheck(int sid);
//	学生申请奖学金
	@Insert("insert into bursary(b_sid,b_crid) values (#{sid},#{credit})")
	public void insertBursary(int sid,int credit);
	
	
//	查询所有等级考试信息
	@Select("select * from ccie")
	public List<Ccie> findAllCcie();
	
//	学生报名登记考试
	@Insert("insert into ccie_student(sc_cid,sc_sid) values (#{cid},#{id})")
	public void insertCcie(int cid,int id);
	
//	查询所有选修课
	@Select("select * from elective")
	public List<Elective> findAllEle();
	
//	学生报名选修课
	@Insert("insert into ele_sut(eles_sid,eles_elid) values (#{eid},#{id})")
	public void insertEle(int eid,int id);
	
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
	@Insert("insert into exam_stu(es_sid,es_eid,estate) values (#{sid},#{eid},#{state})")
	public void insertExam(int sid,int eid,int state);
}
