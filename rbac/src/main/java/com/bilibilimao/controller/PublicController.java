package com.bilibilimao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {
	@RequestMapping("{page}")
	public String jspPage(@PathVariable String page) {
		return(page);
	}
	@RequestMapping("loginpage")
	public String loginPage() {
		return "forward:/WEB-INF/page/login.jsp";
	}
}