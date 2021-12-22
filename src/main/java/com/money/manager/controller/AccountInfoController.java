package com.money.manager.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.money.manager.dto.AccountInfoDTO;
import com.money.manager.service.AccountInfoService;

@Controller
@RequestMapping(value="/accountInfo/*")
public class AccountInfoController {
	@Autowired
	private AccountInfoService ais;
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detaul(@RequestParam("a_number") long a_number, Model model) {
		System.out.println("accountInfo.detail 호출됨");
		
		List<AccountInfoDTO> aiList = ais.detail(a_number);
		model.addAttribute("aiList", aiList);
		
		
		return "/account/findAll";
	}
	
	@RequestMapping(value="createform", method=RequestMethod.GET)
	public String createForm(@RequestParam("a_number") long a_number, @RequestParam("a_bank") String a_bank) {
		
		return "/account/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(@ModelAttribute AccountInfoDTO aiDTO) throws IllegalStateException, IOException {
		ais.create(aiDTO);
		// accountInfo 에서 가는 것은 그냥  대표로 가는거고 그 안에서 다시 전체 내역을 보여줘야 하기 때문에... 다르게 생각해야 할꺼 같은데.
		return "/account/findAll";
	}
}
