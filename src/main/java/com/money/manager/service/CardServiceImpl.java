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

import com.money.manager.dto.CardDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {
	@Autowired
	private CardRepository dr;
	
	@Override
	public List<CardDTO> findAll(long c_number) {
		// TODO Auto-generated method stub
		return dr.findAll(c_number);
	}

	@Override
	public CardDTO detail(long d_number) {
		// TODO Auto-generated method stub
		return dr.detail(d_number);
	}

	@Override
	public void create(CardDTO dDTO) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		MultipartFile d_photo = dDTO.getD_photo();
		String d_pName = d_photo.getOriginalFilename();
		
		d_pName = System.currentTimeMillis() + "-" + d_pName;
		
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + d_pName;
		
		if(!d_photo.isEmpty()) {
			d_photo.transferTo(new File(savePath));
		}
		
		dDTO.setD_pName(d_pName);
		
		dr.create(dDTO);
	}

	private static final int PAGE_LIMIT = 10;
	private static final int BLOCK_LIMIT = 5;
	
	@Override
	public List<CardDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		int pagingStart = (page - 1) * PAGE_LIMIT;
		
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		
		List<CardDTO> dList = dr.pagingList(pagingParam);
		for(CardDTO d: dList) {
			System.out.println(d.toString());
		}
		
		return dList;
	}

	@Override
	public PageDTO paging(int page, @RequestParam("c_number") long c_number) {
		// TODO Auto-generated method stub
		int dCount = dr.dCount(c_number);
		int maxPage = (int)(Math.ceil((double)(dCount / PAGE_LIMIT)));
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
		
		System.out.println("Card.pDTO.toString : " + pDTO.toString());
		
		return pDTO;
	}

}
