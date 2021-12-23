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
import com.money.manager.dto.ClientDTO;
import com.money.manager.service.CashInfoService;
import com.money.manager.service.CashService;
import com.money.manager.service.ClientService;

@Controller
@RequestMapping(value="/cash/*")
public class CashController {
	@Autowired
	private CashService ss;
	@Autowired
	private ClientService cs;
	@Autowired
	private CashInfoService sis;
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model, @RequestParam("c_number") long c_number) {
		System.out.println("cash.findAll 호출됨");
		List<CashDTO> sList = ss.findAll(c_number);
		model.addAttribute("sList", sList);
		
		return "/cash/findAll";
	}
	
	@RequestMapping(value="createform", method=RequestMethod.GET)
	public String createForm(@RequestParam("c_number") long c_number, Model model) {
		ClientDTO cDTO = cs.detail(c_number);
		model.addAttribute("cDTO", cDTO);
		
		return "/cash/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(@ModelAttribute CashDTO sDTO) throws IllegalStateException, IOException {
		ss.create(sDTO);
		
		return "cash/findAll";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam("s_number") long s_number) {
		ss.delete(s_number);
		
		return "redirect:/cash/findAll";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET) // cashinfo에 있는 내역들을 전부 불러오는 연산 필
	public String detail(@RequestParam("s_number") long s_number, Model model) {
		CashDTO sDTO = ss.detail(s_number);
		model.addAttribute("sDTO", sDTO);
		
		// cashinfo의 모든 정보를 가지고 오는 호출
		List<CashInfoDTO> siList = sis.detailList(s_number);
		model.addAttribute("siList", siList);
		
		return "/cash/detail";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@RequestParam("s_number") long s_number, @ModelAttribute CashDTO sDTO) throws IllegalStateException, IOException {
		ss.update(sDTO);
		
		return "redirect:/cash/findAll";
	}
	
}
