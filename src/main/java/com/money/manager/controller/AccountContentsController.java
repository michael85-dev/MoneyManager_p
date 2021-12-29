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

import com.money.manager.dto.AccountContentsDTO;
import com.money.manager.dto.AccountInfoDTO;
import com.money.manager.service.AccountContentsService;
import com.money.manager.service.AccountInfoService;

@Controller
@RequestMapping(value="/accountcontents/*")
public class AccountContentsController {
	@Autowired
	private AccountContentsService acs;
	@Autowired
	private AccountInfoService ais;
	
	@RequestMapping(value="findAll", method=RequestMethod.GET) // 점검 필요
	public String detail(@RequestParam("a_number") long a_number, @RequestParam("ai_number") long ai_number, Model model) {
		List<AccountContentsDTO> acList = acs.findAll(ai_number);
		model.addAttribute("acList", acList);
		
		return "/accountinfo/findAll";
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String updateForm(@RequestParam("ai_number") long ai_number, Model model, @RequestParam("ac_number") long ac_number) {
		acs.detailSource(ac_number); // 수정 필
		AccountContentsDTO acDTO = acs.detailSource(ac_number);
		
		model.addAttribute("acDTO", acDTO);
		
		return "/accountcontents/update";
	}
	
	@RequestMapping(value="createForm", method=RequestMethod.GET) // 헤딩 메서드 경로를 다시 봐야 할 것으로 생각됨.
	public String createForm(@RequestParam("ai_number") long ai_number, Model model) {
		AccountInfoDTO aiDTO = ais.detail(ai_number); //이렇게 해서 Ai_number를 불러와도 되는 건가?
		model.addAttribute("aiDTO", aiDTO);
		
		return "/accountcontents/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(@ModelAttribute AccountContentsDTO acDTO, @RequestParam("ai_number") long ai_number, Model model) throws IllegalStateException, IOException {
		acs.create(acDTO, ai_number);
		
		return "/accountinfo/findAll";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(@RequestParam("ac_number") long ac_number, Model model) {
		AccountContentsDTO acDTO = acs.detailSource(ac_number);
		model.addAttribute("acDTO", acDTO);
		
		return "/accountcontents/detail";
	}
}
