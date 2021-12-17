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

import com.money.manager.dto.ClientDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.service.ClientService;

@Controller
@RequestMapping(value="/client/*")
public class ClientController { // 회원가입 요청을 위한 링크를 받는 메서드
	@Autowired
	private ClientService cs;
	
	@RequestMapping(value="joinform", method=RequestMethod.GET)
	public String joinForm() {
		System.out.println("joinform 링크 전송 받음");
		
		return "/client/join";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute ClientDTO cDTO) throws IllegalStateException, IOException {
		cs.join(cDTO);
		
		return "main";
	}
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model) {
		List<ClientDTO> cList = cs.findAll();
		model.addAttribute("cList", cList);
		
		return "/client/findAll";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(@RequestParam("c_number") long c_number, Model model) {
		ClientDTO cDTO = cs.detail(c_number);
		model.addAttribute("cDTO", cDTO);
		
		return "/client/detail";
	}
	
	@RequestMapping(value="updateform", method=RequestMethod.GET)
	public String updateForm(@RequestParam("c_number") long c_number, Model model) {
		ClientDTO cDTO = cs.detail(c_number);
		model.addAttribute("cDTO", cDTO);
		
		return "/client/update";
	}
	
	// update 실행. -> 모든 값을 보내기만 하는것
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute ClientDTO cDTO) throws IllegalStateException, IOException {
		cs.update(cDTO);
		
		return "redirect:/client/detail?c_number=" + cDTO.getC_number();
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam("c_number") long c_number) {
		cs.delete(c_number);
		
		return "redirect:/client/findAll";
	}
	
	@RequestMapping(value="paging", method=RequestMethod.GET)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model) {
		PageDTO pDTO = cs.paging(page);
		List<ClientDTO> cList = cs.pagingList(page);
		model.addAttribute("pDTO", pDTO);
		model.addAttribute("cList", cList);
		
		return "/client/findAll";
	}
	
//	@RequestMapping(value="search", me) // 후에 처
}
