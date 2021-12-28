package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.CardInfoDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.repository.CardInfoRepository;
import com.money.manager.repository.CardRepository;

@Service
public class CardInfoServiceImpl implements CardInfoService {
	@Autowired
	private CardInfoRepository cir;
	@Autowired
	private CardRepository dr;
	
//	@Override
//	public List<CardInfoDTO> findAll() {
//		// TODO Auto-generated method stub
//		return cir.findAll();
//	}

	@Override
	public List<CardInfoDTO> findAll(long d_number) {
		// TODO Auto-generated method stub
		return cir.findAll(d_number);
	}

	@Override
	public void create(CardInfoDTO ciDTO, long d_number) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		long asset = dr.detail(d_number).getD_tAsset();
		
		asset = asset + ciDTO.getDi_pAsset();
		
		dr.detail(d_number).setD_tAsset(asset);
		
		MultipartFile ci_photo = ciDTO.getDi_photo();
		String di_pName = ci_photo.getOriginalFilename();
		
		di_pName = System.currentTimeMillis() + "-" + di_pName;
		System.out.println("di_pName : " + di_pName);
		
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + di_pName;
		
		if (!ci_photo.isEmpty()) {
			ci_photo.transferTo(new File(savePath));
		}
		
		ciDTO.setDi_pName(di_pName);
			
		cir.create(ciDTO);
	}

	@Override
	public CardInfoDTO detail(long d_number) {
		// TODO Auto-generated method stub
		return cir.detail(d_number);
	}
	
	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 5;

	@Override
	public PageDTO paging(int page, long d_number) {
		// TODO Auto-generated method stub
		int diCount = cir.diCount(d_number);
		int maxPage = (int)(Math.ceil((double)(diCount / PAGE_LIMIT)));
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1);
		
		int endPage = startPage + BLOCK_LIMIT - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageDTO pDTO = new PageDTO();
		pDTO.setPage(page);
		pDTO.setMaxPage(maxPage);
		pDTO.setEndPage(endPage);
		pDTO.setStartPage(startPage);
		
		System.out.println("diDTO.pDTO.toString : " + pDTO.toString());
		
		return pDTO;
	}

	@Override
	public List<CardInfoDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		int pagingStart = (page - 1) * PAGE_LIMIT;
		
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		
		List<CardInfoDTO> pList = cir.pagingList(pagingParam);
		for (CardInfoDTO di : pList) {
			System.out.println(di.toString());
		}
		
		return pList;
	}

	@Override
	public void update(CardInfoDTO diDTO, long d_number) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		// 자산 설정 -> 이 항목은 하기 CardContents에서 가져오는걸 전부 합칠껀데 따로 pAsset 설정하는 란이 있는가? 없으면 굳이 따로 반영해야 할 필요가 있나?
		long asset = dr.detail(d_number).getD_tAsset();
		
		asset = asset - diDTO.getDi_pAsset();
		
		dr.detail(d_number).setD_pAsset(asset);
		
		
		// 파일명 설정
		MultipartFile di_photo = diDTO.getDi_photo();
		String di_pName = di_photo.getOriginalFilename();
		
		di_pName = System.currentTimeMillis() + "-" + di_pName;
		
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + di_pName;
		
		if (!di_photo.isEmpty()) {
			di_photo.transferTo(new File(savePath));
		}
		
		diDTO.setDi_pName(di_pName);
		
		cir.update(diDTO);
	}

}
