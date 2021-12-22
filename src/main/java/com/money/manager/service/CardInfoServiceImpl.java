package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.CardInfoDTO;
import com.money.manager.repository.CardInfoRepository;

@Service
public class CardInfoServiceImpl implements CardInfoService {
	@Autowired
	private CardInfoRepository cir;
	
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
	public void create(CardInfoDTO ciDTO) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
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

}
