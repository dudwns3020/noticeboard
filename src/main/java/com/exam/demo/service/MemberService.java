package com.exam.demo.service;

import org.springframework.stereotype.Service;

import com.exam.demo.repository.MemberRepository;
import com.exam.demo.vo.Member;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public Member getMemberId(int id) {
		return memberRepository.getMemberId(id);
	}
	
	public Member getMemeberLoginId(String loginId) {
		return memberRepository.getMemberLoginId(loginId);
	}
	
	private Member getMemberNamePhoneNo(String name, String phoneNo) {
		return memberRepository.memberRepository(name, phoneNo);
	}

	public int join(String loginId, String loginPw, String name, String phoneNo) {
		
		Member dupLoginId = getMemeberLoginId(loginId);
		
		if (dupLoginId != null) {
			return -1;
		}
		
		dupLoginId = getMemberNamePhoneNo(name, phoneNo);
		
		if (dupLoginId != null) {
			return -2;
		}
		
		return memberRepository.join(loginId, loginPw, name, phoneNo);
	}

}