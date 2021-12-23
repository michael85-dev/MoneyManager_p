package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.CashDTO;
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

}
