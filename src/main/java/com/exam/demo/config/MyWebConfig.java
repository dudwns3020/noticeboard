package com.exam.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.exam.demo.interceptor.BeforeActionInterceptor;
import com.exam.demo.interceptor.NeedLoginInterceptor;

public class MyWebConfig implements WebMvcConfigurer {

	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;
	@Autowired
	NeedLoginInterceptor needLoginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration interceptorRegistration = registry.addInterceptor(beforeActionInterceptor);

		interceptorRegistration.addPathPatterns("/**").excludePathPatterns("/resource/**");

		registry.addInterceptor(needLoginInterceptor).addPathPatterns("/usr/article/doAdd")
				.addPathPatterns("/usr/article/doDelete").addPathPatterns("/usr/article/doModify");
	}
}
