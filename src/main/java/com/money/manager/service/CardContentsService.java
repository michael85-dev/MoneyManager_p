package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.CardContentsDTO;
import com.money.manager.dto.PageDTO;

public interface CardContentsService {

	List<CardContentsDTO> findAll(long di_number);

	void create(CardContentsDTO dcDTO, long di_number) throws IllegalStateException, IOException;

	CardContentsDTO detail(long dc_number);

	void update(CardContentsDTO dcDTO, long dc_number) throws IllegalStateException, IOException;

	PageDTO pageing(int page, long di_number);

	List<CardContentsDTO> pagingList(int page);


}
