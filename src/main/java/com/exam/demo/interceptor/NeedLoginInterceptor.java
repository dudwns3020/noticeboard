package com.exam.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.exam.demo.vo.Rq;

public class NeedLoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Rq rq = (Rq) request.getAttribute("rq");

		if (!rq.isLogined()) {
			
			rq.printHistoryBackJs();
			
			return false;
		}

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
