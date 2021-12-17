package com.money.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.money.manager.dto.AccountDTO;
import com.money.manager.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository ar;
	
	@Override
	public List<AccountDTO> findAll() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public void create(AccountDTO aDTO) {
		// TODO Auto-generated method stub
		
	}

}
