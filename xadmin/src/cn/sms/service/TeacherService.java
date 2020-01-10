package cn.sms.service;

import java.util.List;

import cn.sms.bean.StudentInf;
import cn.sms.bean.TeacherCourse;
import cn.sms.bean.TeacherCourseTable;
import cn.sms.bean.TeacherInf;
import cn.sms.bean.TeacherStudent;

public interface TeacherService {

	List<TeacherInf> listAllTeacher();

	Integer getCount();

	Integer delTeacher(String teacher_number);

	Integer addTeacher(TeacherInf teacherInf);

	Integer updateTeacher(TeacherInf teacherInf);

	TeacherInf getInfByTeacherNumber(String teacher_number);

	Integer addTeacherCourse(TeacherCourseTable teacherCourseTable);

	List<TeacherCourse> listTeacherCourse(String string);

	Integer getTeacherCourseCount(String teacher_number);

	List<TeacherCourse> TeacherCourseStudent(String teacher_number);

	Integer getTeacherCourseStudentCount(String teacher_number);

	List<TeacherStudent> myCourseStudent(String teacher_number);

	Integer delTeacherCourse(String teacher_id);

}
