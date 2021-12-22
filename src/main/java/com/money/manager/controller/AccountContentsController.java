package com.money.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.money.manager.dto.AccountContentsDTO;
import com.money.manager.service.AccountContentsService;

@Controller
@RequestMapping(value="/accountcontents/*")
public class AccountContentsController {
	@Autowired
	private AccountContentsService acs;
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String defail(@RequestParam("a_number") long a_number, @RequestParam("ai_number") long ai_number, Model model) {
		List<AccountContentsDTO> acList = acs.detail(ai_number);
		model.addAttribute("acList", acList);
		
		return "/accountinfo/detail";
	}
	
}
