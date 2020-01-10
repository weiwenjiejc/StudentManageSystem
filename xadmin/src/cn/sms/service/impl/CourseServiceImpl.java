package cn.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sms.bean.CourseInf;
import cn.sms.bean.StudentInf;
import cn.sms.bean.TeacherInf;
import cn.sms.dao.CourseDao;
import cn.sms.dao.TeacherDao;
import cn.sms.service.CourseService;
import cn.sms.service.TeacherService;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;

	

	@Override
	public List<CourseInf> listAllCourse() {
		// TODO Auto-generated method stub
		List<CourseInf> courses = courseDao.listAllCourse();
		return courses;
	}



	@Override
	public Integer getAllCourseCount() {
		// TODO Auto-generated method stub
		Integer count = courseDao.getAllCourseCount();
		return count;
	}

}
