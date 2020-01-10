package cn.sms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sms.bean.TeacherCourse;
import cn.sms.bean.SelectedCourse;
import cn.sms.bean.StudentInf;
import cn.sms.bean.TeacherInf;
import cn.sms.service.StudentService;

@Controller
@RequestMapping("/student/request")
public class StudentRequestController {
	private static Logger logger = Logger.getLogger(StudentRequestController.class);
	@Autowired
	private StudentService studentService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	@RequestMapping(value="/addStudent",produces = "application/json;charset=utf-8")
	 public String addStudent(StudentInf studentInf){
		System.out.println("添加学生:"+studentInf);
		logger.info("添加学生:"+studentInf);
		System.out.println(studentInf);
		Integer res = studentService.addStudent(studentInf);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("code", res.toString());
		String value = null;
		try {
			value = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	@RequestMapping(value = "/delStudent", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String delStudent(String student_number) {
		System.out.println("删除学生:"+student_number);
		Integer res = studentService.delStudent(student_number);
		System.out.println("teacher_number:" + student_number);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("code", 1);
		String value = null;
		try {
			value = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	private ObjectMapper objectMapper = new ObjectMapper();
	/* 列出所有的学生 */

	@RequestMapping(value = "/listAllStudent", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String listAllTeacher() {
		List<StudentInf> teachers = studentService.listAllStudent();
		Integer count = studentService.getCount();
		System.out.println(teachers);
		HashMap<Object, Object> res = new HashMap<>();
		res.put("code", 0);
		res.put("msg", "0");
		res.put("count", count);
		/*
		 * List<List<TeacherInf>> lists = new ArrayList<List<TeacherInf>>();
		 * lists.add(teachers); res.put("data", lists);
		 */
		res.put("data", teachers);
		String value = null;
		try {
			value = objectMapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(value);
		return value;
	}

	/* 更新学生信息 */
	@RequestMapping(value="/updateStudent",produces = "application/json;charset=utf-8")
	 public String updateStudent(StudentInf studentInf){
		System.out.println("修改学生信息:");
		System.out.println(studentInf);
		Integer res = studentService.updateStudent(studentInf);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("code", res.toString());
		String value = null;
		try {
			value = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	/*
	 * 查询已选课程
	 * 
	 */
	@RequestMapping(value = "/listSelectedCourse", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String listSelectedCourse() {
		System.out.println("学生查询已选课程:");
		/* 获得登陆用户信息 */
		HttpSession session = request.getSession();
		StudentInf studentInf = (StudentInf) session.getAttribute("LoginUser");
		List<SelectedCourse> courses = studentService.listSelectedCourse(studentInf.getStudent_number());
		Integer count = 0;
		if (courses != null) {
			count = courses.size();
		}
		HashMap<Object, Object> map = new HashMap<>();
		map.put("code", 0);// 一定要设置为0
		map.put("msg", "0");
		map.put("count", count);
		map.put("data", courses);
		/* 返回信息 */
		String value = null;
		try {
			value = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(value);
		System.out.println("请求结束");
		return value;
	}

	/* 取消选课 */
	@RequestMapping(value = "/unOrderCourse", produces = "application/json;charset=utf-8")
	public String unOrderCourse(String teacher_id) {
		System.out.println("课程编号:");
		System.out.println(teacher_id);

		/* 获得登陆用户信息 */
		HttpSession session = request.getSession();
		StudentInf studentInf = (StudentInf) session.getAttribute("LoginUser");

		Integer res = studentService.unOrderCourse(studentInf.getStudent_number(), Integer.parseInt(teacher_id));
		Integer rs = studentService.updateTeacherCourseDel(Integer.parseInt(teacher_id));
		System.out.println("rs"+rs);
		/* 返回信息 */
		HashMap<Object, Object> map = new HashMap<>();
		map.put("msg", 1);
		String value = null;
		try {
			value = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	/*
	 * 选课
	 * 
	 */
	@RequestMapping(value = "/OrderCourse", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String OrderCourse(String teacher_id) {
		System.out.println("课程编号:");
		System.out.println(teacher_id);

		/* 获得登陆用户信息 */
		HttpSession session = request.getSession();
		StudentInf studentInf = (StudentInf) session.getAttribute("LoginUser");
		HashMap<Object, Object> map = new HashMap<>();
		/* 判断课程是否选择 */
		Integer flag = studentService.isHaveSelected(studentInf.getStudent_number(), Integer.parseInt(teacher_id));
		if (flag == 1) {
			/* 已经选择 */
			map.put("msg", 0);
		} else {
			/* 未选择 */
			/* 查询是否已经达到最大课程，此项由前端判断 */
			Integer res = studentService.OrderCourse(studentInf.getStudent_number(), Integer.parseInt(teacher_id));
			/* 返回信息 */
			/* 选择成功，修改教师课程信息 */
			System.out.println("res");
			System.out.println(res);
			/*
			 * if (res >=1) { 修改教师授课信息 map.put("msg", 1); Integer rs =
			 * studentService.updateTeacherCourse(Integer.parseInt(teacher_id)); }else {
			 * map.put("msg", 3); }
			 */
			map.put("msg", 1);
			studentService.updateTeacherCourse(Integer.parseInt(teacher_id));
		}
		String value = null;
		try {
			value = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	/* 查看所有课程信息 */
	@RequestMapping(value = "/listCourse", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String listAllCourse() {
		System.out.println("请求课程");
		List<TeacherCourse> courses = studentService.listAllCourse();

		HashMap<Object, Object> map = new HashMap<>();
		//Integer count = studentService.getAllCourseCount();
		Integer count  = 0;
		if (courses!=null) {
			count=courses.size();
		}
		map.put("code", 0);
		map.put("msg", "0");
		map.put("count", count);
		map.put("data", courses);
		String value = null;
		if (courses != null) {

			try {
				value = objectMapper.writeValueAsString(map);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(value);
		}
		return value;
	}
}
