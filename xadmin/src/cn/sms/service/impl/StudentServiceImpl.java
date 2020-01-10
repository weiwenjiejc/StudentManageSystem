package cn.sms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sms.bean.TeacherCourse;
import cn.sms.bean.SelectedCourse;
import cn.sms.bean.StudentCourseTable;
import cn.sms.bean.StudentInf;
import cn.sms.bean.TeacherInf;
import cn.sms.dao.CourseDao;
import cn.sms.dao.StudentDao;
import cn.sms.dao.TeacherDao;
import cn.sms.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private TeacherDao teacherDao;
	@Override
	public List<TeacherCourse> listAllCourse() {
		// TODO Auto-generated method stub
		List<TeacherCourse> courses = studentDao.listAllCourse();
		return courses;
	}
	
	@Override
	public Integer OrderCourse(String student_number, Integer teacher_id) {
		// TODO Auto-generated method stub
		Integer res = studentDao.OrderCourse(student_number, teacher_id);
		return res;
	}
	@Override
	public StudentInf getInfByStudnetNumber(String student_number) {
		// TODO Auto-generated method stub
		StudentInf studentInf = studentDao.getInfByStudnetNumber(student_number);
		return studentInf;
	}

	@Override
	public Integer getAllCourseCount() {
		// TODO Auto-generated method stub
		Integer count = courseDao.getAllCourseCount();
		return count;
	}

	@Override
	public List<SelectedCourse> listSelectedCourse(String student_number) {
		// TODO Auto-generated method stub
		ArrayList<SelectedCourse> selectedCourses = new ArrayList<SelectedCourse>();
		List<Integer>teacher_id = studentDao.getCourseByStudentNumber(student_number);
		for(Integer x:teacher_id) {
			//获得没门课程的老师，和课程名
			SelectedCourse selectedCourse= courseDao.listSelectedCourse(x);
			selectedCourses.add(selectedCourse);
		}
		 
		return selectedCourses;
	}

	@Override
	public Integer getSelectedCourseCount(String student_number) {
		// TODO Auto-generated method stub
		Integer count = studentDao.getSelectedCourseCount(student_number);
		return count;
	}

	@Override
	public Integer unOrderCourse(String student_number, Integer teacher_id) {
		// TODO Auto-generated method stub
		Integer res = studentDao.unOrderCourse(student_number,teacher_id);
		return res;
	}

	@Override
	public List<StudentInf> listAllStudent() {
		// TODO Auto-generated method stub
		List<StudentInf> students = studentDao.listAllStudent();
		return students;
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		Integer count = studentDao.getCount();
		return count;
	}

	@Override
	public Integer isHaveSelected(String student_number, Integer teacher_id) {
		// TODO Auto-generated method stub
		StudentCourseTable studentCourseTable = studentDao.isHaveSelected(student_number, teacher_id);
		if (studentCourseTable!=null) {
			return 1;
		}
		return 0;
	}

	@Override
	public Integer delStudent(String student_number) {
		// TODO Auto-generated method stub
		Integer rs = studentDao.delStudent(student_number);
		return rs;
	}

	@Override
	public Integer updateTeacherCourse(Integer teacher_id) {
		// TODO Auto-generated method stub
		Integer rs = teacherDao.updateTeacherCourse(teacher_id);
		return rs;
	}

	@Override
	public Integer updateTeacherCourseDel(Integer teacher_id) {
		// TODO Auto-generated method stub
		Integer rs = teacherDao.updateTeacherCourseDel(teacher_id);
		return rs;
	}

	@Override
	public Integer updateStudent(StudentInf studentInf) {
		Integer rs = studentDao.updateStudent(studentInf);
		// TODO Auto-generated method stub
		return rs;
	}

	@Override
	public Integer addStudent(StudentInf studentInf) {
		// TODO Auto-generated method stub
		Integer rs = studentDao.addStudent(studentInf);
		return rs;
	}
	
}
