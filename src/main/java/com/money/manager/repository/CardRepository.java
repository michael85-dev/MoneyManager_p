package com.money.manager.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.money.manager.dto.CardDTO;

@Repository
public class CardRepository {
	@Autowired
	private SqlSessionTemplate sql;

	public List<CardDTO> findAll() {
		// TODO Auto-generated method stub
		return sql.selectList("Card.findAll");
	}

	public CardDTO detail(long d_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("Card.detail", d_number);
	}

	public void create(CardDTO dDTO) {
		// TODO Auto-generated method stub
		sql.insert("Card.create", dDTO);
	}
	
	
}
