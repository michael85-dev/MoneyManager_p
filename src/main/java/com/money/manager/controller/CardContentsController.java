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

import com.money.manager.dto.CardContentsDTO;
import com.money.manager.dto.CardInfoDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.service.CardContentsService;
import com.money.manager.service.CardInfoService;

@Controller
@RequestMapping(value="/cardcontents/*")
public class CardContentsController {
	@Autowired
	private CardInfoService dis;
	@Autowired
	private CardContentsService dcs;
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(@RequestParam("di_number") long di_number, Model model) {
//		List<CardInfoDTO> diDTO = dis.findAll();
		List<CardContentsDTO> dcDTO = dcs.findAll(di_number);
		model.addAttribute("dcDTO", dcDTO);
		
		return "/cardinfo/findAll";
	}
	
	@RequestMapping(value="createform", method=RequestMethod.GET)
	public String createForm(@RequestParam("di_number") long di_number, @ModelAttribute CardContentsDTO dcDTO, Model model) {
		CardInfoDTO diDTO = dis.detail(di_number);
		model.addAttribute("diDTO", diDTO);
		
		return "/cardinfo/findAll";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(@ModelAttribute CardContentsDTO dcDTO, @RequestParam("di_number") long di_number) throws IllegalStateException, IOException {
		dcs.create(dcDTO, di_number);
		
		return "/cardinfo/findAll";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(@RequestParam("dc_number") long dc_number, Model model) {
		CardContentsDTO dcDTO = dcs.detail(dc_number);
		model.addAttribute("dcDTO", dcDTO);
		
		return "/cardcontents/detail";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute CardContentsDTO dcDTO, @RequestParam("dc_number") long dc_number) throws IllegalStateException, IOException {
		dcs.update(dcDTO, dc_number);
		
		return "redirect:/cardinfo/findAll";
	}
	
	@RequestMapping(value="paging", method=RequestMethod.GET)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model, @RequestParam("di_number") long di_number) {
		PageDTO pDTO = dcs.pageing(page, di_number);
		List<CardContentsDTO> dcList = dcs.pagingList(page);
		model.addAttribute("pDTO", pDTO);
		model.addAttribute("dcList", dcList);
		
		return "/cardcontents/detail";
	}
}
