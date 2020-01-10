package cn.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class IndexController {

	
	
	@RequestMapping(value="/index")
	 public ModelAndView index(ModelAndView mv,String user){
		if (user!=null) {
			if (user.equals("student")) {
				mv.setViewName("student_main");
			}else if (user.equals("teacher")) {
				mv.setViewName("teacher_main");
			}else if (user.equals("admin")) {
				mv.setViewName("admin_main");
			}
		}
		return mv;
	}
}
