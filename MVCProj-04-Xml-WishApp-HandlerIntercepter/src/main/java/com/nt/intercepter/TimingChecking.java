package com.nt.intercepter;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimingChecking implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		var hour =0;
		
		RequestDispatcher rd = null;
		
		hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour<9 || hour>15) {
			rd=req.getRequestDispatcher("timeout.jsp");
			rd.forward(req, resp);
			return false;
		}
		else
			return true;
	}
}
