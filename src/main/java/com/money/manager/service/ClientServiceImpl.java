package com.money.manager.service;

import java.util.List;

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

	@Override
	public List<ClientDTO> findAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public ClientDTO detail(long c_number) {
		// TODO Auto-generated method stub
		return cr.detail(c_number);
	}

	@Override
	public void update(ClientDTO cDTO) {
		// TODO Auto-generated method stub
		cr.update(cDTO);
	}

	@Override
	public void delete(long c_number) {
		// TODO Auto-generated method stub
		cr.delete(c_number);
	}

}
