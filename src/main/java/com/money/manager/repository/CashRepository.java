package com.money.manager.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.money.manager.dto.CashDTO;

@Repository
public class CashRepository {
	@Autowired
	private SqlSessionTemplate sql;
	
	public List<CashDTO> findAll(long c_number) {
		// TODO Auto-generated method stub
		return sql.selectList("Cash.findAll", c_number);
	}

}
