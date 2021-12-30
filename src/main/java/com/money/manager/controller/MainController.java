package com.money.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.money.manager.dto.AccountDTO;
import com.money.manager.dto.AccountInfoDTO;
import com.money.manager.dto.CardDTO;
import com.money.manager.dto.CardInfoDTO;
import com.money.manager.dto.CashDTO;
import com.money.manager.dto.CashInfoDTO;
import com.money.manager.dto.ClientDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.service.AccountContentsService;
import com.money.manager.service.AccountInfoService;
import com.money.manager.service.AccountService;
import com.money.manager.service.CardInfoService;
import com.money.manager.service.CardService;
import com.money.manager.service.CashInfoService;
import com.money.manager.service.CashService;
import com.money.manager.service.ClientService;
import com.money.manager.service.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService ms;
	@Autowired
	private ClientService cs;
	@Autowired
	private AccountService as;
	@Autowired
	private CashService ss;
	@Autowired
	private CardService ds;
	@Autowired
	private AccountInfoService ais;
	@Autowired
	private CardInfoService dis;
	@Autowired
	private CashInfoService sis;
	@Autowired
	private AccountContentsService acs;
	@Autowired

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		System.out.println("처음 화면(index.jsp) 진입");
		
		return "index";
	}
	
	@RequestMapping(value="joinform", method=RequestMethod.GET)
	public String joinForm() {
		System.out.println("joinform 링크 전송 받음");
		
		return "/client/join";
	}
	
	@RequestMapping(value="loginform", method=RequestMethod.GET)
	public String loginForm(Model model) {
		System.out.println("loginform 링크 전송 받음");
		
		List<ClientDTO> cList = cs.findAll();
		
		List<String> cName = new ArrayList<String>();
		
		for(int i = 0; i < cList.size(); i++) {
			cName.add(cList.get(i).getC_id());
		}
		
//		List<AccountDTO> aList = as.findAll();
//		List<Integer> aNum = new ArrayList<Integer>();
//		
//		for (int i = 0; i < aList.size(); i++) {
//			aNum.add(aList.get(i).getA_number());
//		}
		
		model.addAttribute("cName", cName);
		
		
		
		return "/client/login";
	}
	
	@RequestMapping(value="detailform", method=RequestMethod.GET)
	public String detailForm(@RequestParam("c_number") long c_number, Model model) {
		ClientDTO cDTO = cs.detail(c_number);
		model.addAttribute("cDTO", cDTO);
		
		return "/detailform";
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public String findAll(Model model, @RequestParam("c_number") long c_number) {
		System.out.println("전체 조회(메인화면) 기능 실행됨");
		List<AccountDTO> aList = as.findAll(c_number);
		List<CardDTO> dList = ds.findAll(c_number);
		List<CashDTO> sList = ss.findAll(c_number);
		List<ClientDTO> cList = cs.findAll(c_number);
		
		model.addAttribute("cList", cList);
		model.addAttribute("aList", aList);
		model.addAttribute("dList", dList);
		model.addAttribute("sList", sList);
		
		
		
		return "/findAll";
	}
	
	@RequestMapping(value="paging", method=RequestMethod.GET)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model, @RequestParam("c_number") long c_number) {
		PageDTO pcDTO = cs.paging(page);
		PageDTO paDTO = as.paging(page, c_number);
		PageDTO pdDTO = ds.paging(page, c_number);
		PageDTO psDTO = ss.paging(page, c_number);
		
		List<AccountDTO> aList = as.pagingList(page);
		List<CardDTO> dList = ds.pagingList(page);
		List<CashDTO> sList = ss.pagingList(page);
		List<ClientDTO> cList = cs.pagingList(page);
		
		model.addAttribute("pcDTO", pcDTO);
		model.addAttribute("paDTO", paDTO);
		model.addAttribute("psDTO", psDTO);
		model.addAttribute("pdDTO", pdDTO);
		
		model.addAttribute("cList", cList);
		model.addAttribute("aList", aList);
		model.addAttribute("dList", dList);
		model.addAttribute("sList", sList);
		
		return "/client/findAll";
	}
	
	@RequestMapping(value="transform", method=RequestMethod.GET)
	public String transForm(@RequestParam("c_number") long c_number, Model model) {
		List<AccountDTO> aList = as.findAll(c_number);
		List<CardDTO> dList = ds.findAll(c_number);
		List<CashDTO> sList = ss.findAll(c_number);
		
		model.addAttribute("aList", aList);
		model.addAttribute("dList", dList);
		model.addAttribute("sList", sList);
		
		return "/transform";
	}
	
	@RequestMapping(value="atransferform", method=RequestMethod.GET)
	public String accountTrans(@RequestParam("c_number") long c_number, Model model) {
		// 계좌 리스트 불러올 2개를 가지고 와야함. 다만 해당 값에 대해서는. ai_number로 명명 되어야 함. 어떻게 가지고 와야할까?
		List<AccountInfoDTO> a1 = ais.findAll(a_number);
		
		List<AccountInfoDTO> a2 = ais.findAll(a_number);
		return "/account/transform";
	}
	
	@RequestMapping(value="stransferform", method=RequestMethod.GET)
	public String cashTrans(@RequestParam("c_number") long c_number, Model model) {
		List<AccountInfoDTO> a4 = ais.findAll(a_number);
		List<CashInfoDTO> s1 = sis.findAll(s_number);
		
		return "/cash/transform";
	}
	@RequestMapping(value="dtransferform", method=RequestMethod.GET)
	public String cardTrans(@RequestParam("c_number") long c_number, Model model) {
		List<AccountInfoDTO> a3 = ais.findAll(a_number);
		List<CardInfoDTO> d1 = dis.findAll(d_number);
		return "/card/transform";
	}
	
}
