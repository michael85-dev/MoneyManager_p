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

import com.money.manager.dto.AccountDTO;
import com.money.manager.dto.AccountInfoDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.service.AccountInfoService;
import com.money.manager.service.AccountService;

@Controller
@RequestMapping(value="/accountInfo/*")
public class AccountInfoController {
	@Autowired
	private AccountInfoService ais;
	@Autowired
	private AccountService as;
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String detaul(@RequestParam("a_number") long a_number, Model model, @RequestParam("ai_number") long ai_number) {
		System.out.println("accountInfo.detail 호출됨");
		
		List<AccountInfoDTO> aiList = ais.findAll(a_number);
		model.addAttribute("aiList", aiList);
		
		
		return "/account/findAll";
	}
	
	@RequestMapping(value="createform", method=RequestMethod.GET)
	public String createForm(@RequestParam("a_number") long a_number, Model model, @RequestParam("a_bank") String a_bank) {
		AccountDTO aDTO = as.detail(a_number);
		model.addAttribute("aDTO", aDTO);
		
		return "/accountinfo/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(@ModelAttribute AccountInfoDTO aiDTO, @RequestParam("a_number") long a_number) throws IllegalStateException, IOException {
		ais.create(aiDTO, a_number);
		// accountInfo 에서 가는 것은 그냥  대표로 가는거고 그 안에서 다시 전체 내역을 보여줘야 하기 때문에... 다르게 생각해야 할꺼 같은데.
		
		return "/account/findAll";
	}
	
	@RequestMapping(value="paging", method=RequestMethod.GET)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model, @RequestParam("a_number") long a_number) {
		PageDTO pDTO = ais.paging(page, a_number);
		List<AccountInfoDTO> aiDTO = ais.pagingList(page);
		model.addAttribute("pDTO", pDTO);
		model.addAttribute("aiDTO", aiDTO);
		
		return "/account/findAll";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(@RequestParam("ai_number") long ai_number, Model model) {
		AccountInfoDTO aiDTO = ais.detail(ai_number);
		model.addAttribute("aiDTO", aiDTO);
		
		return "/accountinfo/detail";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@RequestParam("a_number") long a_number, Model model, @ModelAttribute AccountInfoDTO aiDTO) throws IllegalStateException, IOException {
		ais.update(aiDTO, a_number);
		
		return "accountinfo/findAll";
	}
}
