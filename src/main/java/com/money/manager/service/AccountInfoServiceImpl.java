package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.AccountInfoDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.repository.AccountInfoRepository;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {
	@Autowired
	private AccountInfoRepository air;
	@Override
	public List<AccountInfoDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountInfoDTO> detail(long a_number) {
		// TODO Auto-generated method stub
		return air.detail(a_number);
	}

	@Override
	public void create(AccountInfoDTO aiDTO) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		MultipartFile ai_photo = aiDTO.getAi_photo();
		String ai_pName= ai_photo.getOriginalFilename();
		
		ai_pName = System.currentTimeMillis() + "-" + ai_pName;
		System.out.println("ai_pName : " + ai_pName);
		
		//파일 저장
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + ai_pName;
		
		if (!ai_photo.isEmpty()) {
			ai_photo.transferTo(new File(savePath));
		}
		
		aiDTO.setAi_pName(ai_pName);
		
		air.create(aiDTO);
	}

	private static final int PAGE_LIMIT = 10;
	private static final int BLOCK_LIMIT = 5; // 후에 가능하면 블록이나 페이지 관련을 변수로 놓고 해당 값을 변경할 수 있게 화기 (시간이 되면)
	
	@Override
	public PageDTO paging(int page, long a_number) {
		// TODO Auto-generated method stub
		int aiCount = air.aiCount(a_number);
		int maxPage = (int)(Math.ceil((double)(aiCount / PAGE_LIMIT)));
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
	public List<AccountInfoDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		int pagingStart = (page - 1) * PAGE_LIMIT;
		
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		
		List<AccountInfoDTO> pList = air.pagingList(pagingParam);
		for (AccountInfoDTO ai : pList) {
			System.out.println("aiList : " + ai.toString());
		}
		
		return pList;
	}

}
