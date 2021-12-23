package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.CashInfoDTO;
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

}
