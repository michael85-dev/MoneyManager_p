package com.money.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/cash/*")
public class CashController {
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model) {
		System.out.println("cash.findAll 호출됨");
		List<CashDTO> sList = sc.findAll();
		
		return "/cash/findAll";
	}
}
