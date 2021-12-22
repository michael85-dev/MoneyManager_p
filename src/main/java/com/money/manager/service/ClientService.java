package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.ClientDTO;
import com.money.manager.dto.PageDTO;

public interface ClientService {

	void join(ClientDTO cDTO) throws IllegalStateException, IOException;

	List<ClientDTO> findAll();

	ClientDTO detail(long c_number);

	void update(ClientDTO cDTO) throws IllegalStateException, IOException;

	void delete(long c_number);

	PageDTO paging(int page);

	List<ClientDTO> pagingList(int page);

	ClientDTO login(ClientDTO cDTO);

}
