package com.money.manager.service;

import java.util.List;

import com.money.manager.dto.ClientDTO;

public interface ClientService {

	void join(ClientDTO cDTO);

	List<ClientDTO> findAll();

	ClientDTO detail(long c_number);

	void update(ClientDTO cDTO);

	void delete(long c_number);

}
