package com.money.manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.money.manager.dto.AccountDTO;

@Controller
@RequestMapping(value="/account/*")
public class AccountController {
	@Autowired
	private AccountService as;
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model) {
		System.out.println("account.findAll 호출");
		List<AccountDTO> aList = as.findAll();
		
		return "/account/findAll";
	}
}
