package com.exam.demo.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.Getter;

public class Rq {
	@Getter
	private boolean isLogined;
	@Getter
	private int loginedId;

	private HttpServletRequest req;
	private HttpServletResponse res;
	private HttpSession httpSession;

	public Rq(HttpServletRequest req, HttpServletResponse res) {

		this.httpSession = req.getSession();
		this.req = req;
		this.res = res;

		boolean isLogined = false;
		int loginedId = 0;

		if (httpSession.getAttribute("loginedId") != null) {
			isLogined = true;
			loginedId = (int) httpSession.getAttribute("loginedId");
		}

		this.isLogined = isLogined;
		this.loginedId = loginedId;
	}

	public void printHistoryBackJs() {

		res.setContentType("text/html; charset=utf-8");
		print("<script>");
		print("alert('로그인이 필요합니다')");
		print("history.back();");
		print("<script>");
	}

	public void print(String msg) {
		try {
			res.getWriter().append(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
