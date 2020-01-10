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
import cn.sms.bean.StudentInf;
import cn.sms.bean.TeacherInf;
import cn.sms.service.StudentService;
import cn.sms.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value="/haveSelectCourse")
	 public ModelAndView haveSelectCourse(ModelAndView mv){
		mv.setViewName("haveSelectCourse");
		return mv;
	}
	
	@RequestMapping(value="/TeacherCourseStudent")
	 public ModelAndView TeacherCourseStudent(ModelAndView mv){
		mv.setViewName("teacher/TeacherCourseStudent");
		return mv;
	}
	/* 登录控制 */
	@RequestMapping(value="/login")
	public ModelAndView login(ModelAndView mv){
		HttpSession session = request.getSession();
		System.out.println("tiao");
		String teacher_number = (String) request.getAttribute("username");
		String password = (String) request.getAttribute("password");
		System.out.println(teacher_number+":"+password);
		TeacherInf teacherInf = teacherService.getInfByTeacherNumber(teacher_number);
		if (teacherInf==null) {
			mv.addObject("msg", "用户不存在");
			mv.setViewName("login");
			mv.addObject("msg", "用户不存在");
		}else {
			System.out.println("登录人信息"+teacherInf);
			if (teacherInf.getPassword().equals(password)) {
				mv.setViewName("teacher_main");
				session.setAttribute("LoginUser", teacherInf);
			}
			else {
				mv.addObject("msg", "密码错误");
				mv.setViewName("login");
			}
		}
		return mv;
	}
	@RequestMapping(value="/addTeacher")
	 public ModelAndView addTeacher(ModelAndView mv){
		mv.setViewName("/teacher/addTeacher");
		return mv;
	}
	
	@RequestMapping(value="/listTeacherCourse")
	 public ModelAndView listTeacherCourse(ModelAndView mv){
		mv.setViewName("/teacher/listTeacherCourse");
		return mv;
	}
	@RequestMapping(value="/addTeacherCourse")
	 public ModelAndView addTeacherCourse(ModelAndView mv){
		HttpSession session = request.getSession();
		TeacherInf teacherInf = (TeacherInf) session.getAttribute("LoginUser");
		mv.addObject("teacher_number",teacherInf.getTeacher_number());
		mv.setViewName("/teacher/addTeacherCourse");
		return mv;
	}
	@RequestMapping(value="/updateTeacher")
	 public ModelAndView updateTeacher(ModelAndView mv,String teacher_number,String teacher_name){
		mv.addObject("teacher_number", teacher_number);
		mv.addObject("teacher_number", teacher_name);
		mv.setViewName("/teacher/updateTeacher");
		return mv;
	}
	@RequestMapping(value="/updateTeacher2")
	 public ModelAndView updateTeacher2(ModelAndView mv,String teacher_number){
		mv.addObject("teacher_number", teacher_number);
		mv.setViewName("/teacher/updateTeacher2");
		return mv;
	}
	@RequestMapping(value="/listTeacher")
	 public ModelAndView listTeacher(ModelAndView mv){
		mv.setViewName("teacher/listTeacher");
		return mv;
	}
	@RequestMapping(value="/selectCourseStudent")
	 public ModelAndView selectCourseStudent(ModelAndView mv){
		mv.setViewName("teacher/selectCourseStudent");
		return mv;
	}
	
}
