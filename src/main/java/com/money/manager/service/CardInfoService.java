package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.CardInfoDTO;
import com.money.manager.dto.PageDTO;

public interface CardInfoService {

//	List<CardInfoDTO> findAll();

	List<CardInfoDTO> findAll(long d_number);

	void create(CardInfoDTO ciDTO) throws IllegalStateException, IOException;

	CardInfoDTO detail(long d_number);

	PageDTO paging(int page, long d_number);

	List<CardInfoDTO> pagingList(int page);

}
