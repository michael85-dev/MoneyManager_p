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

import com.money.manager.dto.CashDTO;
import com.money.manager.dto.CashInfoDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.service.CashInfoService;
import com.money.manager.service.CashService;

@Controller
@RequestMapping(value="/cashinfo/*")
public class CashInfoController {
	@Autowired
	private CashInfoService sis;
	@Autowired
	private CashService ss;
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(@RequestParam("s_number") long s_number, Model model) {
		List<CashInfoDTO> siList = sis.findAll(s_number);
		model.addAttribute("siList", siList);
		
		return "/cash/findAll";
	}
	@RequestMapping(value="createform", method=RequestMethod.GET)
	public String createForm(@RequestParam("s_number") long s_number, Model model) {
		CashDTO sDTO = ss.detail(s_number);
		model.addAttribute("sDTO", sDTO);
		
		return "/cashinfo/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(@ModelAttribute CashInfoDTO siDTO, @RequestParam("s_number") long s_number) throws IllegalStateException, IOException {
		sis.create(siDTO, s_number);
		
		return "/cash/findAll";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute CashInfoDTO siDTO, @RequestParam("s_number") long s_number) throws IllegalStateException, IOException {
		sis.updatae(siDTO, s_number);
		
		return "/cash/findAll";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(@RequestParam("si_number") long si_number, Model model) {
		CashInfoDTO siDTO = sis.detail(si_number);
		model.addAttribute("siDTO", siDTO);
		
		return "/cashinfo/detail";
	}
	
	@RequestMapping(value="page", method=RequestMethod.GET)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model, @RequestParam("si_number") long s_number) {
		PageDTO pDTO = sis.paging(page, s_number);
		List<CashInfoDTO> siList = sis.pagingList(page);
		model.addAttribute("pDTO", pDTO);
		model.addAttribute("siList", siList);
		
		return "/Cash/findAll";
	}
}
