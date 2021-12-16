package com.money.manager.service;

import java.util.List;

import com.money.manager.dto.AccountDTO;

public interface AccountService {

	List<AccountDTO> findAll();

}
