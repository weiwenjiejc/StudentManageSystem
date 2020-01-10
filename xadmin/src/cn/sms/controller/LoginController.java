package cn.sms.controller;

import javax.management.MBeanAttributeInfo;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sms.service.LoginService;

@Controller
public class LoginController {

	
	@Autowired
	private LoginService loginService;
	@Autowired
	HttpServletRequest request;
	@RequestMapping("/login_jsp")
	ModelAndView login_jsp(ModelAndView mv) {
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("/login")
	String login(String username,String password,String identity) {
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		if (identity.equals("0")) {
			//管理员
			if (username.equals("admin")&&password.equals("toor")) {
				return "admin_main";
			}else {
				request.setAttribute("msg", "用户或密码错误");
				return "login";
			}
			
		}else if (identity.equals("1")) {
			//教师
			return "forward:/teacher/login";
			
		}else if (identity.equals("2")) {
			//学生
			return "forward:/student/login";			
	
		}
		return "error";
	}
}
