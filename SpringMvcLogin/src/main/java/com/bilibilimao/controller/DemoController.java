package com.bilibilimao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import com.bilibilimao.service.UserService;
import com.bilibilimao.Utils.SessionUtils;
import com.bilibilimao.po.User;

@Controller
public class DemoController {
	@Autowired
	private UserService userService;
	@RequestMapping("{page}")
	public String main(@PathVariable String page) {
		return(page);
	}
	@RequestMapping("login")
	public String login(User user, HttpServletResponse response) {
		user = userService.findUserByNameAndPassword(user);
		if(user == null) {
			return "redirect:/login.jsp";
		}
		else {
			String uuid = SessionUtils.putUserSession(user);
			Cookie cookie = new Cookie("userinfo", uuid);
			cookie.setMaxAge(1800);
			cookie.setPath("/SpringMvcLogin");
			response.addCookie(cookie);
			return "main";			
		}
	}
}