package com.money.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.money.manager.dto.AccountDTO;
import com.money.manager.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository ar;
	
	@Override
	public List<AccountDTO> findAll(long c_number) {
		// TODO Auto-generated method stub
		return ar.findAll(c_number);
	}

	@Override
	public void create(AccountDTO aDTO) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		MultipartFile a_photo = aDTO.getA_photo();
		String a_pName = a_photo.getOriginalFilename();
		
		a_pName = System.currentTimeMillis() + "-" + a_pName;
		System.out.println("a_pName : " + a_pName);
		
		String savePath = "/Users/myungha/Desktop/Github/MoneyManager/src/main/webapp/resources/upload" + a_pName;
		
		if (!a_photo.isEmpty()) {
			a_photo.transferTo(new File(savePath));
		}
		
		aDTO.setA_pName(a_pName);
		
		ar.create(aDTO);
	}

	@Override
	public AccountDTO detail(long a_number) {
		// TODO Auto-generated method stub
		return ar.detail(a_number);
	}

	@Override
	public void update(long a_number) {
		// TODO Auto-generated method stub
		ar.update(a_number);
	}

	@Override
	public AccountDTO login(AccountDTO aDTO) {
		// TODO Auto-generated method stub
		return ar.login(aDTO);
	}

}
