package com.money.manager.service;

import java.util.List;

import com.money.manager.dto.AccountDTO;

public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository ar;
	
	@Override
	public List<AccountDTO> findAll() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

}
