package cn.sms.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sms.service.LoginService;

@Controller
public class LogoutController {

	@Autowired
	private LoginService loginService;
	@Autowired
	HttpServletRequest request;

	/*
	 * @RequestMapping("/login_jsp") ModelAndView login_jsp(ModelAndView mv) {
	 * mv.setViewName("login"); return mv; }
	 */
	@RequestMapping("/logout")
	String logout() {
		HttpSession session = request.getSession();
		session.removeAttribute("LoginUser");
		return "login";
	}
}
