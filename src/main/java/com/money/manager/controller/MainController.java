package com.money.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.money.manager.service.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService ms;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		System.out.println("처음 화면(index.jsp) 진입");
		
		return "index";
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
