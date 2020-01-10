package cn.sms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sms.bean.TeacherCourse;
import cn.sms.bean.CourseInf;
import cn.sms.bean.LoginUser;
import cn.sms.bean.StudentInf;
import cn.sms.bean.TeacherInf;
import cn.sms.service.CourseService;
import cn.sms.service.StudentService;
import cn.sms.service.TeacherService;

@Controller
@RequestMapping("/course/request")
public class CourseRequestController {
	@Autowired
	private CourseService courseService;
	@Autowired
	HttpServletRequest request;

	private ObjectMapper objectMapper = new ObjectMapper();

	/*
	 * @RequestMapping(value="/listCourse") public String listCourse(){
	 * List<TeacherCourse> courses = courseServiceService.listAllCourse(); if
	 * (courses!=null) { String value = null; try { value =
	 * objectMapper.writeValueAsString(courses); } catch (JsonProcessingException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); }
	 * System.out.println(value); return "success"; } return "error"; }
	 * 
	 * @RequestMapping(value="/listTeacher") public ModelAndView
	 * listTeacher(ModelAndView mv){ mv.setViewName("teacher/listTeacher"); return
	 * mv; }
	 */

	/*
	 * 选课
	 * 
	 */
	/*
	 * @RequestMapping(value="/OrderCourse",produces =
	 * "application/json;charset=utf-8") public String OrderCourse(String
	 * teacher_id){ System.out.println("课程编号:"); System.out.println(teacher_id);
	 * 
	 * 获得登陆用户信息 HttpSession session = request.getSession(); StudentInf studentInf =
	 * (StudentInf) session.getAttribute("LoginUser");
	 * 
	 * 
	 * Integer res =
	 * studentService.OrderCourse(studentInf.getStudent_number(),Integer.parseInt(
	 * teacher_id));
	 * 
	 * 返回信息 HashMap<String, String> map = new HashMap<String, String>();
	 * map.put("code", res.toString()); String value = null; try { value =
	 * objectMapper.writeValueAsString(map); } catch (JsonProcessingException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } return value; }
	 */

	@RequestMapping(value = "/listAllCourse", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String listAllTeacher() {
		List<CourseInf> teachers = courseService.listAllCourse();
		Integer count = courseService.getAllCourseCount();
		System.out.println(teachers);
		HashMap<Object, Object> res = new HashMap<>();
		res.put("code", 0);
		res.put("msg", "0");
		res.put("count", count);
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
}
