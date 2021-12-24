package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.AccountDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository ar;
	
	@Override
	public List<AccountDTO> findAll(long c_number) {
		// TODO Auto-generated method stub
		return ar.findAll(c_number);
	}

	@Override
	public void create(AccountDTO aDTO) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		MultipartFile a_photo = aDTO.getA_photo();
		String a_pName = a_photo.getOriginalFilename();
		
		a_pName = System.currentTimeMillis() + "-" + a_pName;
		System.out.println("a_pName : " + a_pName);
		
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + a_pName;
		
		if (!a_photo.isEmpty()) {
			a_photo.transferTo(new File(savePath));
		}
		
		aDTO.setA_pName(a_pName);
		
		ar.create(aDTO);
	}

	@Override
	public AccountDTO detail(long a_number) {
		// TODO Auto-generated method stub
		return ar.detail(a_number);
	}

	@Override
	public void update(long a_number) {
		// TODO Auto-generated method stub
		ar.update(a_number);
	}

	@Override
	public AccountDTO login(AccountDTO aDTO) {
		// TODO Auto-generated method stub
		return ar.login(aDTO);
	}
	
	private static final int PAGE_LIMIT = 3;
	private static final int BLOCK_LIMIT = 5;

	@Override
	public List<AccountDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		int pagingStart = (page - 1) * PAGE_LIMIT;
		
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		
		List<AccountDTO> aList = ar.pagingList(pagingParam);
		for (AccountDTO a: aList) {
			System.out.println(a.toString());
		}
		return aList;
	}

	@Override
	public PageDTO paging(int page, @RequestParam("c_number") long c_number) {
		// TODO Auto-generated method stub
		int aCount = ar.aCount(c_number);
		int maxPage = (int)(Math.ceil((double)(aCount / PAGE_LIMIT)));
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1);
		
		int endPage = startPage + BLOCK_LIMIT - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageDTO pDTO = new PageDTO();
		pDTO.setPage(page);
		pDTO.setStartPage(startPage);
		pDTO.setMaxPage(maxPage);
		pDTO.setEndPage(endPage);
		
		System.out.println("account.pDTO.toString : " + pDTO.toString());
		return pDTO;
	}



}
