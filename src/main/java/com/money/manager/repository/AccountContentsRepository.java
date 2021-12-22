package com.money.manager.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.money.manager.dto.AccountContentsDTO;

@Repository
public class AccountContentsRepository {
	@Autowired
	private SqlSessionTemplate sql;

	public List<AccountContentsDTO> detail(long ai_number) {
		// TODO Auto-generated method stub
		return sql.selectList("AccountContents.detail", ai_number);
	}
	
	
}
