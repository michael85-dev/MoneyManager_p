package com.money.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.money.manager.dto.AccountDTO;
import com.money.manager.dto.ClientDTO;
import com.money.manager.service.AccountService;
import com.money.manager.service.ClientService;
import com.money.manager.service.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService ms;
	@Autowired
	private ClientService cs;
	@Autowired
	private AccountService as;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		System.out.println("처음 화면(index.jsp) 진입");
		
		return "index";
	}
	
	@RequestMapping(value="joinform", method=RequestMethod.GET)
	public String joinForm() {
		System.out.println("joinform 링크 전송 받음");
		
		return "/client/join";
	}
	
	@RequestMapping(value="loginform", method=RequestMethod.GET)
	public String loginForm(Model model) {
		System.out.println("loginform 링크 전송 받음");
		
		List<ClientDTO> cList = cs.findAll();
		
		List<String> cName = new ArrayList<String>();
		
		for(int i = 0; i < cList.size(); i++) {
			cName.add(cList.get(i).getC_id());
		}
		
//		List<AccountDTO> aList = as.findAll();
//		List<Integer> aNum = new ArrayList<Integer>();
//		
//		for (int i = 0; i < aList.size(); i++) {
//			aNum.add(aList.get(i).getA_number());
//		}
		
		model.addAttribute("cName", cName);
		
		
		
		return "/client/login";
	}
	
	@RequestMapping(value="detailform", method=RequestMethod.GET)
	public String detailForm(@RequestParam("c_number") long c_number, Model model) {
		ClientDTO cDTO = cs.detail(c_number);
		model.addAttribute("cDTO", cDTO);
		
		return "/detailform";
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public String findAll(Model model) {
		System.out.println("전체 조회(메인화면) 기능 실행됨");
		List<AccountDTO> aList = ms.findAllofAccount();
		List<CardDTO> cList = ms.findAllofCard();
		List<CashDTO> sList = ms.findAllofCash();
		
		return "findAll";
	}
}
