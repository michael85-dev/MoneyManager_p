package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.CashDTO;
import com.money.manager.dto.PageDTO;

public interface CashService {

	List<CashDTO> findAll(long c_number);

	void create(CashDTO sDTO) throws IllegalStateException, IOException;

	void delete(long s_number);

	CashDTO detail(long s_number);

	void update(CashDTO sDTO) throws IllegalStateException, IOException;

	List<CashDTO> pagingList(int page);

	PageDTO paging(int page, long c_number);

}
