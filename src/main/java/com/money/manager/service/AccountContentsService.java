package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.AccountContentsDTO;

public interface AccountContentsService {

	List<AccountContentsDTO> findAll(long ai_number);

	AccountContentsDTO detailSource(long ac_number);

	void create(AccountContentsDTO acDTO, long ai_number) throws IllegalStateException, IOException;

}
