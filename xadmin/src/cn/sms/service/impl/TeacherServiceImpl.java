package cn.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sms.bean.StudentInf;
import cn.sms.bean.TeacherCourse;
import cn.sms.bean.TeacherCourseTable;
import cn.sms.bean.TeacherInf;
import cn.sms.bean.TeacherStudent;
import cn.sms.dao.TeacherDao;
import cn.sms.service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public List<TeacherInf> listAllTeacher() {
		// TODO Auto-generated method stub
		List<TeacherInf> teachers = teacherDao.listAllTeacher();
		return teachers;
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		Integer count = teacherDao.getCount();
		return count;
	}

	@Override
	public Integer delTeacher(String teacher_number) {
		// TODO Auto-generated method stub
		Integer res = teacherDao.delTeacher(teacher_number);
		return res;
	}

	@Override
	public Integer addTeacher(TeacherInf teacherInf) {
		// TODO Auto-generated method stub
		Integer res = teacherDao.addTeacher(teacherInf);
		return res;
	}

	@Override
	public Integer updateTeacher(TeacherInf teacherInf) {
		// TODO Auto-generated method stub
		Integer res = teacherDao.updateTeacher(teacherInf);
		return res;
	}

	@Override
	public TeacherInf getInfByTeacherNumber(String teacher_number) {
		// TODO Auto-generated method stub
		TeacherInf teacherInf = teacherDao.getInfByTeacherNumber(teacher_number);
		return teacherInf;
	}

	@Override
	public Integer addTeacherCourse(TeacherCourseTable teacherCourseTable) {
		// TODO Auto-generated method stub
		Integer result = teacherDao.addTeacherCourse(teacherCourseTable);
		return result;
	}

	/*
	 * @Override public List<TeacherCourse> listTeacherCourse() { // TODO
	 * Auto-generated method stub teacherDao.listTeacherCourse(); return null; }
	 */

	@Override
	public List<TeacherCourse> listTeacherCourse(String teacher_number) {
		// TODO Auto-generated method stub
		//使用两表联合查询
		List<TeacherCourse> teacherCourses = teacherDao.listTeacherCourse(teacher_number);
		return teacherCourses;
	}

	@Override
	public Integer getTeacherCourseCount(String teacher_number) {
		// TODO Auto-generated method stub
		Integer count = teacherDao.getTeacherCourseCount(teacher_number);
		return count;
	}

	@Override
	public List<TeacherCourse> TeacherCourseStudent(String teacher_number) {
		// TODO Auto-generated method stub
		List<TeacherCourse> teacherCourses = teacherDao.TeacherCourseStudent(teacher_number);
		return teacherCourses;
	}

	@Override
	public Integer getTeacherCourseStudentCount(String teacher_number) {
		// TODO Auto-generated method stub
		Integer count = teacherDao.getTeacherCourseStudentCount(teacher_number);
		return count;
	}

	@Override
	public List<TeacherStudent> myCourseStudent(String teacher_number) {
		// TODO Auto-generated method stub
		List<TeacherStudent> teacherStudents = teacherDao.myCourseStudent(teacher_number);
		return teacherStudents;
	}

	@Override
	public Integer delTeacherCourse(String teacher_id) {
		// TODO Auto-generated method stub
		Integer rs = teacherDao.delTeacherCourse(teacher_id);
		return rs;
	}

}
