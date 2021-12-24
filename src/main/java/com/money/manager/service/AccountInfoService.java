package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.AccountInfoDTO;
import com.money.manager.dto.PageDTO;

public interface AccountInfoService {

	List<AccountInfoDTO> findAll();

	List<AccountInfoDTO> detail(long a_number);

	void create(AccountInfoDTO aiDTO) throws IllegalStateException, IOException;

	PageDTO paging(int page, long a_number);

	List<AccountInfoDTO> pagingList(int page);

}
