package cn.sms.service;

import java.util.List;

import cn.sms.bean.TeacherCourse;
import cn.sms.bean.SelectedCourse;
import cn.sms.bean.StudentInf;
import cn.sms.bean.TeacherInf;

public interface StudentService {

	List<TeacherCourse> listAllCourse();

	Integer OrderCourse(String student_number,Integer teacher_id);

	StudentInf getInfByStudnetNumber(String student_number);

	Integer getAllCourseCount();

	List<SelectedCourse> listSelectedCourse(String student_number);

	Integer getSelectedCourseCount(String student_number);

	Integer unOrderCourse(String student_number, Integer teacher_id);

	List<StudentInf> listAllStudent();

	Integer getCount();

	Integer isHaveSelected(String student_number, Integer teacher_id);

	Integer delStudent(String student_number);

	Integer updateTeacherCourse(Integer teacher_id);

	Integer updateTeacherCourseDel(Integer teacher_id);

	Integer updateStudent(StudentInf studentInf);

	Integer addStudent(StudentInf studentInf);
	

}
