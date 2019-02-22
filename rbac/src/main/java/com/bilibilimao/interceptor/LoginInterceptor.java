package com.bilibilimao.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.bilibilimao.utils.SessionUtils;
import com.bilibilimao.po.User;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie cookies[] = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("user")) {
					User user = SessionUtils.getUserSession(c.getValue());
					if(user != null) {
						SessionUtils.resetTime(c.getValue());
						c.setMaxAge(1800);
						response.addCookie(c);
						request.setAttribute("userinfo", user);
						return true;
					}
				}
			}
		}
		response.sendRedirect("/rbac/loginpage");
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