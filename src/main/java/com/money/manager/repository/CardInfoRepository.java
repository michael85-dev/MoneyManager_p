package com.money.manager.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.money.manager.dto.CardInfoDTO;

@Repository
public class CardInfoRepository {
	@Autowired
	private SqlSessionTemplate sql;

	public List<CardInfoDTO> findAll(long d_number) {
		// TODO Auto-generated method stub
		return sql.selectList("CardInfo.findAll", d_number);
	}

	public void create(CardInfoDTO ciDTO) {
		// TODO Auto-generated method stub
		sql.insert("CardInfo.create", ciDTO);
	}

	public CardInfoDTO detail(long d_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("CardInfo.detail", d_number);
	}
	
	
}
