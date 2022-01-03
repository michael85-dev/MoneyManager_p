package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.AccountInfoDTO;
import com.money.manager.dto.PageDTO;

public interface AccountInfoService {

	List<AccountInfoDTO> findAll();

	List<AccountInfoDTO> findAll(long a_number);

	void create(AccountInfoDTO aiDTO, long a_number) throws IllegalStateException, IOException;

	PageDTO paging(int page, long a_number);

	List<AccountInfoDTO> pagingList(int page);

	AccountInfoDTO detail(long ai_number);

	void update(AccountInfoDTO aiDTO, long a_number) throws IllegalStateException, IOException;

	void send(long a1_number, AccountInfoDTO aiDTO);

	void receive(long a2_number, AccountInfoDTO aiDTO);

}
