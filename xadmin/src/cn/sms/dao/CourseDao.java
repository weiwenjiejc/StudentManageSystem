package cn.sms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sms.bean.TeacherCourse;
import cn.sms.bean.TeacherInf;
import cn.sms.bean.CourseInf;
import cn.sms.bean.SelectedCourse;

public interface CourseDao {

	@Select("SELECT" + 
			"	teacher_id," + 
			"	a.teacher_number," + 
			"	teacher_name," + 
			"	a.course_number," + 
			"	course_name," + 
			"	total," + 
			"	surplus " + 
			"FROM" + 
			"	( teacher_course a INNER JOIN teacher_inf b ON a.teacher_number = b.teacher_number )" + 
			"	INNER JOIN course_inf c ON a.course_number = c.course_number")
	List<TeacherCourse> listAllTeacherCourse();
	
	@Select("select * from course_inf")
	List<CourseInf> listAllCourse();
	
	@Select("select count(*) from teacher_course")
	Integer getAllTeacherCourseCount();
	@Select("select count(*) from course_inf")
	Integer getAllCourseCount();

	@Select("SELECT" + 
			"	teacher_id," + 
			"	a.teacher_number," + 
			"	teacher_name," + 
			"	a.course_number," + 
			"	course_name " + 
			"FROM" + 
			"	( teacher_course a INNER JOIN teacher_inf b ON a.teacher_number = b.teacher_number )" + 
			"	INNER JOIN course_inf c ON a.course_number = c.course_number where teacher_id=#{teacher_id}")
	SelectedCourse listSelectedCourse(@Param("teacher_id")Integer teacher_id);

}
