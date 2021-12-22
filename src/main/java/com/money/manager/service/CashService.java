package com.money.manager.service;

import java.util.List;

import com.money.manager.dto.CashDTO;

public interface CashService {

	List<CashDTO> findAll(long c_number);

}
