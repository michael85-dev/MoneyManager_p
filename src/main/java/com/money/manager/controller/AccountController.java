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
import com.money.manager.dto.ClientDTO;
import com.money.manager.service.AccountInfoService;
import com.money.manager.service.AccountService;
import com.money.manager.service.ClientService;

@Controller
@RequestMapping(value="/account/*")
public class AccountController {
	@Autowired
	private AccountService as;
	@Autowired
	private ClientService cs;
	@Autowired
	private AccountInfoService ais;
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model, @RequestParam("c_number") long c_number) {
		System.out.println("account.findAll 호출");
		List<AccountDTO> aList = as.findAll(c_number);
		model.addAttribute("aList", aList);
		// tAsset의 값을 어떻게 정릐해야하는지에 대해서 고민해야할 것으로 생각이 됨. create에서ㅕ 처리를 해서 넣어야 할까?
		List<AccountInfoDTO> aiList = ais.findAll();
		model.addAttribute("aiList", aiList);
		
		return "/account/findAll";
	}
	
	@RequestMapping(value="createform", method=RequestMethod.GET)
	public String createForm(Model model, @RequestParam("c_number") long c_number) {
		System.out.println("account.createForm 호출됨");
//		고객 정보에 대한 정보를 가져와야함. 로그인한 사람의 정보를 가지고 와야하는데 어떻게 가지고 와야하고 어떻게 불러야 할까?
		ClientDTO cDTO = cs.detail(c_number);
		model.addAttribute("cDTO", cDTO); // c_number를 불러오게 시켜야함. login id를 통해서 number를 불러야 하나? 조금 더 만들면서 생각해보자.
		
		return "/account/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(@ModelAttribute AccountDTO aDTO, @RequestParam("c_number") long c_number) throws IllegalStateException, IOException {
		as.create(aDTO); // 정보를 가지고 와야함. 생성하는 것인만큼. 번호를 그대로 가지고 가야할 수 있음
		
		return "/account/findAll";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(@RequestParam("a_number") long a_number, Model model) {
		AccountDTO aDTO = as.detail(a_number);
		model.addAttribute("aDTO", aDTO);
		
		return "/account/detail";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@RequestParam("a_number") long a_number) {
		System.out.println("Account.update.post 요청됨");
		as.update(a_number);
		
		return "redirect:/account/findAll";
	}
}
