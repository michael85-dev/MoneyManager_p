package com.money.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.manager.dto.CashDTO;
import com.money.manager.repository.CashRepository;

@Service
public class CashServiceImpl implements CashService{
	@Autowired
	private CashRepository sr;
	
	@Override
	public List<CashDTO> findAll(long c_number) {
		// TODO Auto-generated method stub
		return sr,findAll(c_number);
	}

}
