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

import cn.sms.bean.LoginUser;
import cn.sms.bean.TeacherCourse;
import cn.sms.bean.TeacherCourseTable;
import cn.sms.bean.TeacherInf;
import cn.sms.bean.TeacherStudent;
import cn.sms.service.StudentService;
import cn.sms.service.TeacherService;

@Controller
@RequestMapping("/teacher/request")
public class TeacherRequestController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private HttpServletRequest request;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	
	
	@RequestMapping(value="/updateTeacher",produces = "application/json;charset=utf-8")
	 public String updateTeacher(TeacherInf teacherInf){
		System.out.println("修改教师信息:");
		System.out.println(teacherInf);
		Integer res = teacherService.updateTeacher(teacherInf);
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
	@RequestMapping(value="/addTeacher",produces = "application/json;charset=utf-8")
	 public String addTeacher(TeacherInf teacherInf){
		System.out.println(teacherInf);
		Integer res = teacherService.addTeacher(teacherInf);
		HashMap<Object,Object> map = new HashMap<>();
		map.put("code", 0);
		String value = null;
		try {
			value = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	@RequestMapping(value="/delTeacherCourse",produces = "application/json;charset=utf-8")
	@ResponseBody
	 public String delTeacherCourse(String teacher_id){
		System.out.println("删除授课");
		Integer res = teacherService.delTeacherCourse(teacher_id);
		System.out.println("teacher_number:"+teacher_id);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("code", Integer.toString(res));
		String value = null;
		try {
			value = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	@RequestMapping(value="/delTeacher",produces = "application/json;charset=utf-8")
	@ResponseBody
	 public String delTeacher(String teacher_number){
		int res = teacherService.delTeacher(teacher_number);
		System.out.println("teacher_number:"+teacher_number);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("code", Integer.toString(res));
		String value = null;
		try {
			value = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	@RequestMapping(value="/listAllTeacher",produces = "application/json;charset=utf-8")
	@ResponseBody
	 public String listAllTeacher(){
		List<TeacherInf> teachers = teacherService.listAllTeacher();
		int count = teacherService.getCount();
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
	
	/* 新版授课学生查询 */
	@RequestMapping(value="/myCourseStudent",produces = "application/json;charset=utf-8")
	@ResponseBody
	 public String myCourseStudent(){
		HttpSession session = request.getSession();
		TeacherInf user = (TeacherInf) session.getAttribute("LoginUser");
		if (user==null) {
			return "{\"code\":0,\"msg\":0,\"count\":0,\"data\":[]}";
		}
		if (user.getTeacher_number()==null) {
			return "{\"code\":0,\"msg\":0,\"count\":0,\"data\":[]}";
		}
		List<TeacherStudent> teacherStudents = teacherService.myCourseStudent(user.getTeacher_number());
		Integer count =0; // = teacherService.getTeacherCourseStudentCount(user.getTeacher_number());
		if (teacherStudents!=null) {
			count=teacherStudents.size();
		}
		System.out.println(teacherStudents);
		HashMap<Object, Object> res = new HashMap<>();
		res.put("code", 0);
		res.put("msg", "0");
		res.put("count", count);
		res.put("data", teacherStudents);
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
	/* 授课学生查询 */
	@RequestMapping(value="/TeacherCourseStudent",produces = "application/json;charset=utf-8")
	@ResponseBody
	 public String TeacherCourseStudent(){
		HttpSession session = request.getSession();
		TeacherInf user = (TeacherInf) session.getAttribute("LoginUser");
		if (user.getTeacher_number()==null) {
			return "{\"code\":0,\"msg\":0,\"count\":0,\"data\":[]}";
		}
		List<TeacherCourse> teachers = teacherService.TeacherCourseStudent(user.getTeacher_number());
		Integer count = teacherService.getTeacherCourseStudentCount(user.getTeacher_number());
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
	@RequestMapping(value="/listTeacherCourse",produces = "application/json;charset=utf-8")
	@ResponseBody
	 public String listTeacherCourse(){
		HttpSession session = request.getSession();
		TeacherInf user = (TeacherInf) session.getAttribute("LoginUser");
		List<TeacherCourse> teachers = teacherService.listTeacherCourse(user.getTeacher_number());
		Integer count = teacherService.getTeacherCourseCount(user.getTeacher_number());
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
	/* 添加老师所授的课程 */
	@RequestMapping(value="/addTeacherCourse",produces = "application/json;charset=utf-8")
	 public String addTeacherCourse(TeacherCourseTable teacherCourseTable){
		System.out.println("添加授课课程"+teacherCourseTable);
		teacherCourseTable.setSurplus(teacherCourseTable.getTotal());
		Integer res = teacherService.addTeacherCourse(teacherCourseTable);
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
}
