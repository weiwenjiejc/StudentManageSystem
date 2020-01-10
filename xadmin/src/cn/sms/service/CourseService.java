package cn.sms.service;

import java.util.List;

import cn.sms.bean.CourseInf;
import cn.sms.bean.StudentInf;
import cn.sms.bean.TeacherInf;

public interface CourseService {

	

	List<CourseInf> listAllCourse();

	Integer getAllCourseCount();

}
