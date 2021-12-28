package com.money.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.manager.dto.AccountContentsDTO;
import com.money.manager.repository.AccountContentsRepository;

@Service
public class AccountContentsServiceImpl implements AccountContentsService {
	@Autowired
	private AccountContentsRepository acr;
	
	@Override
	public List<AccountContentsDTO> detail(long ai_number) {
		// TODO Auto-generated method stub
		return acr.detail(ai_number);
	}

	@Override
	public AccountContentsDTO detailSource(long ac_number) {
		// TODO Auto-generated method stub
		return acr.detailSource(ac_number);
	}

}
