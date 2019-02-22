package com.bilibilimao.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bilibilimao.po.User;
import com.bilibilimao.service.UserService;
import com.bilibilimao.utils.SessionUtils;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("login")
	public String login(User user, HttpServletResponse response) {
		user = userService.VerifyAccountPassword(user);
		if(user != null) {
			String uuid = SessionUtils.putUserSession(user);
			Cookie cookie = new Cookie("user", uuid);
			cookie.setMaxAge(1800);
			cookie.setPath("/rbac");
			response.addCookie(cookie);
			return "redirect:/menu/main";
		}
		return "redirect:/loginpage";
	}
}