package cn.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class WelcomeController {
	
	@RequestMapping(value="/welcome")
	 public ModelAndView listTeacher(ModelAndView mv){
		mv.setViewName("welcome");
		return mv;
	}
}
