package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.AccountDTO;
import com.money.manager.dto.PageDTO;

public interface AccountService {

	List<AccountDTO> findAll(long c_number);

	void create(AccountDTO aDTO) throws IllegalStateException, IOException;

	AccountDTO detail(long a_number);

	void update(AccountDTO aDTO, long a_number);

	AccountDTO login(AccountDTO aDTO);

	List<AccountDTO> pagingList(int page);

	PageDTO paging(int page, long c_number);

}
