package cn.sms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import cn.sms.bean.TeacherCourse;
import cn.sms.bean.TeacherCourseTable;
import cn.sms.bean.TeacherInf;
import cn.sms.bean.TeacherStudent;
import cn.sms.dao.provider.TeacherSqlProvider;

public interface TeacherDao {

	@SelectProvider(type=TeacherSqlProvider.class,method = "insertTeacher")
	Integer addTeacher(TeacherInf teacher);
	/*
	 * @UpdateProvider(type = TeacherSqlProvider.class,method = "updateTeacher")
	 * Integer updateTeacher(TeacherInf teacher);
	 */
	@Update("update teacher_inf set teacher_name=#{teacher_name},password=#{password} where teacher_number=#{teacher_number}")
	Integer updateTeacher(TeacherInf teacher);
	@Select("select * from teacher_inf")
	List<TeacherInf> listAllTeacher();
	@Select("select count(*) from teacher_inf")
	Integer getCount();
	@Delete("delete from teacher_inf where teacher_number=#{teacher_number}")
	Integer delTeacher(String teacher_number);
	@Select("select * from teacher_inf where teacher_number=#{teacher_number}")
	TeacherInf getInfByTeacherNumber(String teacher_number);
	@Insert("insert into teacher_course(teacher_number,course_number,total,surplus)values(#{teacher_number},#{course_number},#{total},#{surplus})")
	Integer addTeacherCourse(TeacherCourseTable teacherCourseTable);
	
	@Select("SELECT teacher_id,a.teacher_number,a.course_number,course_name,total,surplus FROM (teacher_course a INNER JOIN course_inf b on a.course_number = b.course_number) where a.teacher_number=#{teacher_number}")
	List<TeacherCourse> listTeacherCourse(String teacher_number);
	@Select("select count(*) from teacher_course where teacher_number=#{teacher_number}")
	Integer getTeacherCourseCount(String teacher_number);
	@Select("SELECT teacher_id,a.student_number,student_name from (student_inf a JOIN student_course b on a.student_number = b.student_number) where b.teacher_id in (SELECT teacher_id from teacher_course where teacher_number=#{teacher_number})")
	List<TeacherCourse> TeacherCourseStudent(String teacher_number);
	@Select("SELECT count(*) from (student_inf a JOIN student_course b on a.student_number = b.student_number) where b.teacher_id in (SELECT teacher_id from teacher_course where teacher_number=#{teacher_number})")
	Integer getTeacherCourseStudentCount(String teacher_number);
	@Update("update teacher_course set surplus=surplus-1 where teacher_id=#{teacher_id}")
	Integer updateTeacherCourse(Integer teacher_id);
	@Update("update teacher_course set surplus=surplus+1 where teacher_id=#{teacher_id}")
	Integer updateTeacherCourseDel(Integer teacher_id);
	@Select("SELECT a.student_number,student_name,teacher_id from (student_course a join student_inf b on a.student_number=b.student_number) where student_id in (SELECT student_id from teacher_inf where teacher_number=#{teacher_number})")
	List<TeacherStudent> myCourseStudent(String teacher_number);
	@Delete("delete from teacher_course where teacher_id=#{teacher_id}")
	Integer delTeacherCourse(String teacher_id);
	

}
