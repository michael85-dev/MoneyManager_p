package com.money.manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.money.manager.dto.CardDTO;

@Controller
@RequestMapping(value="/card/*")
public class CardController {
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model) {
		System.out.println("card.findAll 호출됨");
		List<CardDTO> dList = ds.findAll();
		
		return "/card/findAll";
	}
}
