package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.CashInfoDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.repository.CashInfoRepository;

@Service
public class CashInfoServiceImpl implements CashInfoService {
	@Autowired
	private CashInfoRepository sir;
	
	@Override
	public List<CashInfoDTO> findAll(long s_number) {
		// TODO Auto-generated method stub
		return sir.findAll(s_number);
	}

	@Override
	public List<CashInfoDTO> detailList(long s_number) {
		// TODO Auto-generated method stub
		return sir.detailList(s_number);
	}

	@Override
	public void create(CashInfoDTO siDTO) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		MultipartFile si_photo = siDTO.getSi_photo();
		String si_pName = si_photo.getOriginalFilename();
		
		si_pName = System.currentTimeMillis() + "-" + si_pName;
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + si_pName;
		
		if (!si_photo.isEmpty()) {
			si_photo.transferTo(new File(savePath));
		}
		
		siDTO.setSi_pName(si_pName);
		
		sir.create(siDTO);
	}

	@Override
	public CashInfoDTO detail(long si_number) {
		// TODO Auto-generated method stub
		return sir.detail(si_number);
	}

	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 5;
	
	@Override
	public PageDTO paging(int page, long s_number) {
		// TODO Auto-generated method stub
		int siCount = sir.siCount(s_number);
		int maxPage = (int)(Math.ceil((double)(siCount / PAGE_LIMIT)));
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
		
		System.out.println("aiDTO.pDTO.toString : " + pDTO.toString());
		
		return pDTO;
	}

	@Override
	public List<CashInfoDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		int pagingStart = (page - 1) * PAGE_LIMIT;
		
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limilt", PAGE_LIMIT);
		
		List<CashInfoDTO> pList = sir.pagingList(pagingParam);
		for (CashInfoDTO si : pList) {
			System.out.println("si.toString : " + si.toString());
		}
		
		return pList;
	}

}
