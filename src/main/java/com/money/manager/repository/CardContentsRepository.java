package com.money.manager.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.money.manager.dto.CardContentsDTO;

@Repository
public class CardContentsRepository {
	@Autowired
	private SqlSessionTemplate sql;
	
	public List<CardContentsDTO> findAll(long di_number) {	
		// TODO Auto-generated method stub
		return sql.selectList("CardContents.findAll", di_number);
	}

	public void create(CardContentsDTO dcDTO) {
		// TODO Auto-generated method stub
		sql.insert("CardContents.create", dcDTO);
	}

	public CardContentsDTO detail(long dc_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("CardContents.detail", dc_number);
	}

	public void update(CardContentsDTO dcDTO) {
		// TODO Auto-generated method stub
		sql.update("CardContents.update", dcDTO);
	}

	public List<CardContentsDTO> pagingList(Map<String, Integer> pagingParam) {
		// TODO Auto-generated method stub
		return sql.selectList("CardContents.pList", pagingParam);
	}

	public int dcCount(long di_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("CardContents.count", di_number);
	}

}
