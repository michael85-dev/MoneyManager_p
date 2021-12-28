package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.CashDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.repository.CashRepository;

@Service
public class CashServiceImpl implements CashService{
	@Autowired
	private CashRepository sr;
	
	@Override
	public List<CashDTO> findAll(long c_number) {
		// TODO Auto-generated method stub
		return sr.findAll(c_number);
	}

	@Override
	public void create(CashDTO sDTO) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		MultipartFile s_photo = sDTO.getS_photo();
		String s_pName = s_photo.getOriginalFilename();
		
		s_pName = System.currentTimeMillis() + "-" + s_pName;
		System.out.println("s_pName : " + s_pName);
		
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + s_pName;
		
		if (!s_photo.isEmpty()) {
			s_photo.transferTo(new File(savePath));
		}
		
		sDTO.setS_pName(s_pName);
		
		sr.create(sDTO);
	}

	@Override
	public void delete(long s_number) {
		// TODO Auto-generated method stub
		sr.delete(s_number);
	}

	@Override
	public CashDTO detail(long s_number) {
		// TODO Auto-generated method stub
		return sr.detail(s_number);
	}

	@Override
	public void update(CashDTO sDTO) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		
		MultipartFile s_photo = sDTO.getS_photo();
		String s_pName = s_photo.getOriginalFilename();
		
		s_pName = System.currentTimeMillis() + "-" + s_pName;
//		s_pName = sDTO.getS_pName();
		
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + s_pName;
		
		if (!s_photo.isEmpty()) {
			s_photo.transferTo(new File(savePath));
		}
		
		sDTO.setS_pName(s_pName);
		
		sr.update(sDTO);
	}

	private static final int PAGE_LIMIT = 10;
	private static final int BLOCK_LIMIT = 5;
	
	@Override
	public List<CashDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		int pagingStart = (page - 1) * PAGE_LIMIT;
		
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limig", PAGE_LIMIT);
		
		List<CashDTO> sList = sr.pagingList(pagingParam);
		for (CashDTO s: sList) {
			System.out.println(s.toString());
		}
				
		return sList;
	}

	@Override
	public PageDTO paging(int page, @RequestParam("c_number") long c_number) {
		// TODO Auto-generated method stub
		int sCount = sr.sCount(c_number);
		int maxPage = (int)(Math.ceil((double)(sCount / PAGE_LIMIT)));
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1);
		
		int endPage = startPage + BLOCK_LIMIT - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageDTO pDTO = new PageDTO();
		pDTO.setPage(page);
		pDTO.setEndPage(endPage);
		pDTO.setMaxPage(maxPage);
		pDTO.setStartPage(startPage);
		
		System.out.println("cash.pDTO.toString : " + pDTO.toString());

		return pDTO;
	}

}
