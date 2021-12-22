package com.money.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.money.manager.dto.CashDTO;
import com.money.manager.service.CashService;

@Controller
@RequestMapping(value="/cash/*")
public class CashController {
	@Autowired
	private CashService ss;
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model, @RequestParam("c_number") long c_number) {
		System.out.println("cash.findAll 호출됨");
		List<CashDTO> sList = ss.findAll(c_number);
		
		return "/cash/findAll";
	}
	
}
