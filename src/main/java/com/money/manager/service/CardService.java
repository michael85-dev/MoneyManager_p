package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.CardDTO;
import com.money.manager.dto.PageDTO;

public interface CardService {

	List<CardDTO> findAll(long c_number);

	CardDTO detail(long d_number);

	void create(CardDTO dDTO) throws IllegalStateException, IOException;

	List<CardDTO> pagingList(int page);

	PageDTO paging(int page, long c_number);

}
