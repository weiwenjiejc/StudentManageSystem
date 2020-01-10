package cn.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sms.bean.TeacherCourse;
import cn.sms.service.StudentService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private StudentService studentService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	
	@RequestMapping(value="/listCourse")
	 public ModelAndView listCourse(ModelAndView mv){
		mv.setViewName("course/listCourse");
		return mv;
	}
	@RequestMapping(value="/listAllCourse")
	 public String listAllCourse(){
		List<TeacherCourse> courses = studentService.listAllCourse();
		if (courses!=null) {
			String value = null;
			try {
				value = objectMapper.writeValueAsString(courses);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(value);
			return "success";
		}
		return "error";
	}
}
