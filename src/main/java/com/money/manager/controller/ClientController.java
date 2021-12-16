package com.money.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.money.manager.dto.ClientDTO;
import com.money.manager.service.ClientService;

@Controller
@RequestMapping(value="/client/*")
public class ClientController { // 회원가입 요청을 위한 링크를 받는 메서드
	@Autowired
	private ClientService cs;
	
	@RequestMapping(value="joinform", method=RequestMethod.GET)
	public String joinForm() {
		System.out.println("joinform 링크 전송 받");
		
		return "/client/join";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute ClientDTO cDTO) {
		cs.join(cDTO);
		
		return "main";
	}
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model) {
		List<ClientDTO> cList = cs.findAll();
		model.addAttribute("cList", cList);
		
		return "/client/findAll";
	}
}
