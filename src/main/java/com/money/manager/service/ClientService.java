package com.money.manager.service;

import java.util.List;

import com.money.manager.dto.ClientDTO;

public interface ClientService {

	void join(ClientDTO cDTO);

	List<ClientDTO> findAll();

}
