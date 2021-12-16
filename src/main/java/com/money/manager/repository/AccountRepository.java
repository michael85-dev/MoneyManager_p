package com.money.manager.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.money.manager.dto.AccountDTO;

@Repository
public class AccountRepository {
	@Autowired
	private SqlSessionTemplate sql;
	
	public List<AccountDTO> findAll() {
		// TODO Auto-generated method stub
		return sql.selectList("Account.findAll");
	}

}
