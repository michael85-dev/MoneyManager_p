package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.CardDTO;
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

}
