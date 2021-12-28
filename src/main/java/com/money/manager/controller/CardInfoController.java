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
import com.money.manager.dto.CardDTO;
import com.money.manager.dto.CardInfoDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.service.AccountService;
import com.money.manager.service.CardInfoService;
import com.money.manager.service.CardService;

@Controller
@RequestMapping(value="/cardinfo/*")
public class CardInfoController {
	@Autowired
	private CardInfoService cis;
	@Autowired
	private AccountService as;
	@Autowired
	private CardService ds;
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model, @RequestParam("d_number") long d_number) {

		List<CardInfoDTO> ciList = cis.findAll(d_number);
		model.addAttribute("ciList", ciList);
		
		return "/card/findAll";
	}
	
	@RequestMapping(value="createform", method=RequestMethod.GET)
	public String createForm(@RequestParam("d_number") long d_number, Model model, @RequestParam("a_number") long a_number) { //a_number를 호출해서 A_bank가져오는게 FindAll에 명명 안되어있
		CardDTO dDTO = ds.detail(d_number);
		model.addAttribute("dDTO", dDTO); // card의 해당 d_number를 넘기기 위해
		List<AccountDTO> aList = as.findAll(a_number);
		model.addAttribute("aList", aList);
		
		return "/card/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(@ModelAttribute CardInfoDTO ciDTO, @RequestParam("d_number") long d_number) throws IllegalStateException, IOException {
		cis.create(ciDTO, d_number);
		
		return "/card/findAll";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(@RequestParam("d_number") long d_number, Model model) {
		CardInfoDTO ciDTO = cis.detail(d_number);
		model.addAttribute("ciDTO", ciDTO);
		
		return "/cardinfo/detail";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@RequestParam("d_number") long d_number, Model model, @ModelAttribute CardInfoDTO diDTO) throws IllegalStateException, IOException {
		cis.update(diDTO, d_number);
		
		return "/card/findAll";
	}
	
	@RequestMapping(value="pageing", method=RequestMethod.GET)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model, @RequestParam("d_number") long d_number) {
		PageDTO pDTO = cis.paging(page, d_number);
		List<CardInfoDTO> diDTO = cis.pagingList(page);
		
		model.addAttribute("pDTO", pDTO);
		model.addAttribute("diDTO", diDTO);
		
		return "/card/findAll";
	}
}
