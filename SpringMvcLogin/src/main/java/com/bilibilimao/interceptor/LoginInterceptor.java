package com.bilibilimao.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bilibilimao.Utils.SessionUtils;
import com.bilibilimao.po.User;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie cookies[] = request.getCookies();
		User user;
		for(Cookie c : cookies) {
			if(c.getName().equals("userinfo")) {
				user = SessionUtils.getUserSession(c.getValue());
				if(user != null) {
					SessionUtils.resetTime(c.getValue());
					request.setAttribute("userinfo", user);
					return true;
				}
			}
		}
		response.sendRedirect("/SpringMvcLogin/login.jsp");
		return false;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}