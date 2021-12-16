package com.money.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.manager.dto.ClientDTO;
import com.money.manager.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository cr;
	
	@Override
	public void join(ClientDTO cDTO) {
		// TODO Auto-generated method stub
		cr.join(cDTO);
	}

}
