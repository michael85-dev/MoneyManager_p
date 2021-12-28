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

import com.money.manager.dto.CardContentsDTO;

import com.money.manager.dto.PageDTO;
import com.money.manager.repository.CardContentsRepository;
import com.money.manager.repository.CardInfoRepository;

@Service
public class CardContentsServiceImpl implements CardContentsService {
	@Autowired
	private CardContentsRepository dcr;
	@Autowired
	private CardInfoRepository dir;
	
	@Override
	public List<CardContentsDTO> findAll(long di_number) {
		// TODO Auto-generated method stub
		
		return dcr.findAll(di_number);
	}

	@Override
	public void create(CardContentsDTO dcDTO, @RequestParam("di_number") long di_number) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		// 잔액 조회된것을 상위 값에 넣기
		long asset = dir.detail(di_number).getDi_tAsset();
		asset = asset + dcDTO.getDc_pAsset();
		
		dir.detail(di_number).setDi_tAsset(asset);
		
		
		// 파일 명 생성
		MultipartFile dc_photo = dcDTO.getDc_photo();
		String dc_pName = dc_photo.getOriginalFilename();
		
		dc_pName = System.currentTimeMillis() + "-" + dc_pName;
		
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + dc_pName;
		
		if (!dc_photo.isEmpty()) {
			dc_photo.transferTo(new File(savePath));
		}
		
		dcDTO.setDc_nName(dc_pName);
		
		
		dcr.create(dcDTO);
	}

	@Override
	public CardContentsDTO detail(long dc_number) {
		// TODO Auto-generated method stub
		
		
		return dcr.detail(dc_number);
	}

	@Override
	public void update(CardContentsDTO dcDTO, long dc_number) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		// 기존 데이터는 어떻게 가지고 와야하는거지? 여기서 해당 값을 가지고 올 방법을 찾아야 할것 같은데.
			
			long asset = dcr.detail(dc_number).getDc_tAsset();
		
			asset = asset - dcr.detail(dc_number).getDc_pAsset();
		
		if (!dcDTO.getDc_photo().isEmpty()) {
			MultipartFile dc_photo = dcDTO.getDc_photo();
			String dc_pName = dc_photo.getOriginalFilename();
			
			dc_pName = System.currentTimeMillis() + "-" + dc_pName;
			
			String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + dc_pName;
			
			dc_photo.transferTo(new File(savePath));
			
			dcDTO.setDc_nName(dc_pName);
			
			asset = asset + dcDTO.getDc_pAsset();
			dcDTO.setDc_tAsset(asset);
			
			dcr.update(dcDTO);
			
		} else {
			
			MultipartFile dc_photo = dcDTO.getDc_photo();
			String dc_pName = dc_photo.getOriginalFilename();
			
			dc_pName = System.currentTimeMillis() + "-" + dc_pName;
			
			String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + dc_pName;
			
			if (!dc_photo.isEmpty()) {
				dc_photo.transferTo(new File(savePath));
			}
			
			dcDTO.setDc_nName(dc_pName);
		
			asset = asset + dcDTO.getDc_pAsset();
			dcDTO.setDc_tAsset(asset);
			
			dcr.create(dcDTO);
			
		}
		
		
	}
	
	private static final int BLOCK_LIMIT = 5;
	private static final int PAGE_LIMIT = 3;

	@Override
	public PageDTO pageing(int page, @RequestParam("di_number") long di_number) {
		// TODO Auto-generated method stub
		int dcCount = dcr.dcCount(di_number);
		int maxPage = (int)(Math.ceil((double)(dcCount / PAGE_LIMIT)));
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
		
		return pDTO;
	}

	@Override
	public List<CardContentsDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		int pagingStart = (page - 1) * PAGE_LIMIT;
		
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		
		List<CardContentsDTO> pList = dcr.pagingList(pagingParam);
		
		for (CardContentsDTO dc: pList) {
			System.out.println("pDTO.dc : " + dc.toString());
		}
		
		return pList;
	}

}
