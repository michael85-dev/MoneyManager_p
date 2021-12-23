package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.CashInfoDTO;

public interface CashInfoService {

	List<CashInfoDTO> findAll(long s_number);

	List<CashInfoDTO> detailList(long s_number);

	void create(CashInfoDTO siDTO) throws IllegalStateException, IOException;

	CashInfoDTO detail(long si_number);

}
