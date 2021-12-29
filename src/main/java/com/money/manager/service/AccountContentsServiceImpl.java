package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.AccountContentsDTO;
import com.money.manager.repository.AccountContentsRepository;
import com.money.manager.repository.AccountInfoRepository;

@Service
public class AccountContentsServiceImpl implements AccountContentsService {
	@Autowired
	private AccountContentsRepository acr;
	@Autowired
	private AccountInfoRepository air;
	
	@Override
	public List<AccountContentsDTO> findAll(long ai_number) {
		// TODO Auto-generated method stub
		return acr.findAll(ai_number);
	}

	@Override
	public AccountContentsDTO detailSource(long ac_number) {
		// TODO Auto-generated method stub
		return acr.detailSource(ac_number);
	}

	@Override
	public void create(AccountContentsDTO acDTO, long ai_number) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		long asset = air.detail(ai_number).getAi_pAsset();
		asset = asset + acDTO.getAc_pAsset();
		
		air.detail(ai_number).setAi_pAsset(asset);
		
		MultipartFile ac_photo = acDTO.getAc_photo();
		String ac_pName = ac_photo.getOriginalFilename();
		
		ac_pName = System.currentTimeMillis() + "-" + ac_pName;
		
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + ac_pName;		
		
		if (!ac_photo.isEmpty() ) {
			ac_photo.transferTo(new File(savePath));
		}
		
		acDTO.setAc_nName(ac_pName);
		
		acr.create(acDTO);
	}

}
