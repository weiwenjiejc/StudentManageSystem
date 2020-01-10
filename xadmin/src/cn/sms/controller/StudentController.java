package cn.sms.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sms.bean.TeacherCourse;
import cn.sms.bean.StudentInf;
import cn.sms.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	private static Logger logger = Logger.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;
	@Autowired
	HttpServletRequest request;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping(value="/addStudent")
	 public ModelAndView addStudent(ModelAndView mv){
		mv.setViewName("/student/addStudent");
		return mv;
	}
	@RequestMapping(value="/updateStudent")
	 public ModelAndView updateStudent(ModelAndView mv,String student_number){
		mv.addObject("student_number", student_number);
		mv.setViewName("/student/updateStudent");
		return mv;
	}
	@RequestMapping(value="/updateStudent2")
	 public ModelAndView updateStudent2(ModelAndView mv,String student_number){
		mv.addObject("student_number", student_number);
		mv.setViewName("/student/updateStudent2");
		return mv;
	}
	@RequestMapping(value="/listStudent")
	 public ModelAndView listTeacher(ModelAndView mv){
		mv.setViewName("student/listStudent");
		return mv;
	}
	@RequestMapping(value="/haveSelectCourse")
	 public ModelAndView haveSelectCourse(ModelAndView mv){
		mv.setViewName("student/haveSelectCourse");
		return mv;
	}
	
	@RequestMapping(value="/listCourse")
	 public ModelAndView listCourse(ModelAndView mv){
		mv.setViewName("student/listCourse");
		return mv;
	}
	@RequestMapping(value="/studentInf")
	 public ModelAndView studentInf(ModelAndView mv){
		mv.setViewName("student/studentInf");
		return mv;
	}
	
	/* 登录控制 */
	@RequestMapping(value="/login")
	public ModelAndView login(ModelAndView mv){
		HttpSession session = request.getSession();
		System.out.println("tiao");
		String student_number = (String) request.getAttribute("username");
		String password = (String) request.getAttribute("password");
		System.out.println(student_number+":"+password);
		StudentInf studentInf = studentService.getInfByStudnetNumber(student_number);
		if (studentInf==null) {
			logger.info("用户不存在");
			mv.addObject("msg", "用户不存在");
			mv.setViewName("login");
			mv.addObject("msg", "用户不存在");
		}else {
			System.out.println("登录人信息"+studentInf);
			if (studentInf.getPassword().equals(password)) {
				session.setAttribute("LoginUser", studentInf);
				mv.setViewName("student_main");
			}
			else {
				mv.addObject("msg", "密码错误");
				mv.setViewName("login");
			}
		}
		return mv;
	}
	
}
