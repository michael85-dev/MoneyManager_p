package com.money.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/client/*")
public class ClientController { // 회원가입 요청을 위한 링크를 받는 메서
	@RequestMapping(value="joinform", method=RequestMethod.GET)
	public String JoinForm() {
		System.out.println("joinform 링크 전송 받");
		
		return "/client/join";
	}
}
