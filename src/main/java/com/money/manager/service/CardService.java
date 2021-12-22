package com.money.manager.service;

import java.io.IOException;
import java.util.List;

import com.money.manager.dto.CardDTO;

public interface CardService {

	List<CardDTO> findAll();

	CardDTO detail(long d_number);

	void create(CardDTO dDTO) throws IllegalStateException, IOException;

}
