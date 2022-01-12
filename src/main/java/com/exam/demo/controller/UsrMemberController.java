package com.exam.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.demo.service.MemberService;
import com.exam.demo.ut.Ut;
import com.exam.demo.vo.Member;

@Controller
public class UsrMemberController {

	private MemberService memberService;

	public UsrMemberController(MemberService articleService) {
		this.memberService = articleService;
	}

	@RequestMapping("usr/member/doJoin")
	@ResponseBody
	public String doJoin(String loginId, String loginPw, String name, String phoneNo) {

		int id = memberService.join(loginId, loginPw, name, phoneNo);

		if (id == -1) {
			return Ut.jsHistoryBack("이미 가입된 아이디입니다.");
		}

		if (id == -2) {
			return Ut.jsHistoryBack("이미 가입된 회원입니다.");
		}

		Member member = memberService.getMemberId(id);

		return Ut.jsReplace(Ut.f("회원가입이 완료되었습니다."), "/");

	}

	@RequestMapping("usr/member/join")
	public String showJoin(String loginId, String loginPw, String name, String phoneNo) {

		return "usr/member/join";
	}

	@RequestMapping("usr/member/doLogin")
	@ResponseBody
	public String doLogin(HttpSession httpSession, String loginId, String loginPw) {

		boolean isLogined = false;

		if (httpSession.getAttribute("loginedId") != null) {
			isLogined = true;
		}

		if (isLogined) {
			return Ut.jsReplace(Ut.f("이미 로그인 상태입니다."), "/");			
		}

		Member member = memberService.getMemeberLoginId(loginId);

		if (member == null) {
			return Ut.jsHistoryBack(Ut.f("존재하지 않는 아이디입니다."));
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return Ut.jsHistoryBack(Ut.f("비밀번호가 올바르지 않습니다."));
		}

		httpSession.setAttribute("loginedId", member.getLoginId());

		return Ut.jsReplace(Ut.f("%s님 환영합니다.", member.getName()), "/");
	}

	@RequestMapping("usr/member/login") 
		public String showLogin(String loginId, String loginPw) {
		
			return "usr/member/login";
		}

	@RequestMapping("usr/member/doLogout")
	@ResponseBody
	public String doLogout(HttpSession httpSession) {

		boolean isLogined = false;

		if (httpSession.getAttribute("loginedId") == null) {
			isLogined = true;
		}

		if (isLogined) {
			return Ut.jsReplace(Ut.f("이미 로그아웃 상태입니다."), "/");
		}

		httpSession.removeAttribute("loginedId");

		return Ut.jsReplace(Ut.f("로그아웃 되었습니다."), "/");
	}

}