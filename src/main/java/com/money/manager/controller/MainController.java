package com.money.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		System.out.println("처음 화면(index.jsp) 진입");
		
		return "index";
	}
}
