package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.AccountInfoDTO;

public interface AccountInfoService {

	List<AccountInfoDTO> findAll();

	List<AccountInfoDTO> detail(long a_number);

	void create(AccountInfoDTO aiDTO) throws IllegalStateException, IOException;

}
