package com.bilibilimao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bilibilimao.po.Menu;
import com.bilibilimao.po.User;
import com.bilibilimao.service.MenuService;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	@RequestMapping("main")
	public ModelAndView showMain(HttpServletRequest request) {
		User user = (User)request.getAttribute("userinfo");
		int roleId = user.getId();
		List<Menu> list = menuService.showMain(roleId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("forward:/WEB-INF/page/main.jsp");
		return(modelAndView);
	}
}