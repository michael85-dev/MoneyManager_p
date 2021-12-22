package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.AccountInfoDTO;
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

}
