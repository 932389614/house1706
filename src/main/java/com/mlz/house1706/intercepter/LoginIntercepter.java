package com.mlz.house1706.intercepter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mlz.house1706.domain.User;
import com.mlz.house1706.dto.UserLoginDto;

public class LoginIntercepter implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		Integer user=(Integer) req.getSession().getAttribute("userId");
		System.out.println(user+"-------------------------------------");
		if(user!=null) {
			return true;
		}else {			
			res.sendRedirect("toLogin");
			return false;
		}
	}

}
