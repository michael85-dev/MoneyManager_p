package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.AccountDTO;

public interface AccountService {

	List<AccountDTO> findAll();

	void create(AccountDTO aDTO) throws IllegalStateException, IOException;

	AccountDTO detail(long a_number);

	void update(long a_number);

	AccountDTO login(AccountDTO aDTO);

}
