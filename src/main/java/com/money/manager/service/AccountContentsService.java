package com.money.manager.service;

import java.util.List;

import com.money.manager.dto.AccountContentsDTO;

public interface AccountContentsService {

	List<AccountContentsDTO> detail(long ai_number);

	AccountContentsDTO detailSource(long ac_number);

}
