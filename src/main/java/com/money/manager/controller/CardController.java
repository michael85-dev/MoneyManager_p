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

import com.money.manager.dto.CardDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.service.CardService;

@Controller
@RequestMapping(value="/card/*")
public class CardController {
	@Autowired
	private CardService ds;
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model, @RequestParam("c_number") long c_number) {
		System.out.println("card.findAll 호출됨");
		List<CardDTO> dList = ds.findAll(c_number);
		model.addAttribute("dList", dList);
		
		return "/card/findAll";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET) // 해당 항목 아직 미존재. 왼쪽 탭을 통해 오른쪽에 해당 카드를 넣는 식으로 jsp 에서 설정 필
	public String detail(@RequestParam("d_number") long d_number, Model model) {
		CardDTO dDTO = ds.detail(d_number);
		model.addAttribute("dDTO", dDTO);
		
		return "/cardinfo/detail";
	}
	
	@RequestMapping(value="createform", method=RequestMethod.GET)
	public String createForm(@RequestParam("c_number") long c_number) {
		
		return "/card/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(Model model, @ModelAttribute CardDTO dDTO) throws IllegalStateException, IOException {
		ds.create(dDTO);
		
		return "redirect:/card/findAll";
	}
	
	@RequestMapping(value="paging", method=RequestMethod.GET)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model, @RequestParam("c_number") long c_number) {
		PageDTO pDTO = ds.paging(page, c_number);
		List<CardDTO> dList = ds.pagingList(page);
		model.addAttribute("pDTO", pDTO);
		model.addAttribute("dList", dList);
		
		return "/card/findAll";
	}
}
