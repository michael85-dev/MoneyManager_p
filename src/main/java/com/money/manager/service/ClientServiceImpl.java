package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.ClientDTO;
import com.money.manager.dto.PageDTO;
import com.money.manager.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository cr;
	
	@Override
	public void join(ClientDTO cDTO) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		MultipartFile c_photo = cDTO.getC_photo();
		String c_pName = c_photo.getOriginalFilename();
		
		c_pName = System.currentTimeMillis() + "-"  + c_pName;
		System.out.println("c_pName : " + c_pName);
		
		//파일저장
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + c_pName;
		
		if (!c_photo.isEmpty()) {
			c_photo.transferTo(new File(savePath));
		}
		cDTO.setC_pName(c_pName);
		
		cr.join(cDTO);
	}

	@Override
	public List<ClientDTO> findAll(long c_number) {
		// TODO Auto-generated method stub
		return cr.findAll(c_number);
	}

	@Override
	public ClientDTO detail(long c_number) {
		// TODO Auto-generated method stub
		return cr.detail(c_number);
	}

	@Override
	public void update(ClientDTO cDTO) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		MultipartFile c_photo = cDTO.getC_photo();
		String c_pName = c_photo.getOriginalFilename();
		
		c_pName = System.currentTimeMillis() + "-" + c_pName;
		
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources" + c_pName;
		
		if (!c_photo.isEmpty()) {
			c_photo.transferTo(new File(savePath));
		}
		
		cDTO.setC_pName(c_pName);
		
		cr.update(cDTO);
	}

	@Override
	public void delete(long c_number) {
		// TODO Auto-generated method stub
		cr.delete(c_number);
	}

	private static final int PAGE_LIMIT = 10;
	private static final int BLOCK_LIMIT = 5;
	
	@Override
	public PageDTO paging(int page) {
		// TODO Auto-generated method stub
		int cCount = cr.cCount();
		int maxPage = (int)(Math.ceil((double)(cCount / PAGE_LIMIT)));
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1);
		
		int endPage = startPage + BLOCK_LIMIT - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		PageDTO pDTO = new PageDTO();
		pDTO.setPage(page);
		pDTO.setStartPage(startPage);
		pDTO.setEndPage(endPage);
		pDTO.setMaxPage(maxPage);
		
		System.out.println("pDTO.toString : " + pDTO.toString());
		
		return pDTO;
	}

	@Override
	public List<ClientDTO> pagingList(int page) { //페이징 부분 다시 찾아봐야
		// TODO Auto-generated method stub
		int pagingStart = (page - 1) * PAGE_LIMIT;
		
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		
		List<ClientDTO> pList = cr.pagingList(pagingParam);
		for (ClientDTO c: pList) {
			System.out.println(c.toString());
		}
		
		return pList;
	}

	@Override
	public ClientDTO login(ClientDTO cDTO) {
		// TODO Auto-generated method stub
		return cr.login(cDTO);
	}

	@Override
	public List<ClientDTO> findAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

}
