package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.CardInfoDTO;

public interface CardInfoService {

//	List<CardInfoDTO> findAll();

	List<CardInfoDTO> findAll(long d_number);

	void create(CardInfoDTO ciDTO) throws IllegalStateException, IOException;

	CardInfoDTO detail(long d_number);

}
