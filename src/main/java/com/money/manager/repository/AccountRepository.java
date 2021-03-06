package com.money.manager.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.money.manager.dto.AccountDTO;

@Repository
public class AccountRepository {
	@Autowired
	private SqlSessionTemplate sql;
	
	public List<AccountDTO> findAll(long c_number) {
		// TODO Auto-generated method stub
		return sql.selectList("Account.findAll", c_number);
	}

	public void create(AccountDTO aDTO) {
		// TODO Auto-generated method stub
		sql.insert("Account.create", aDTO);
	}

	public AccountDTO detail(long a_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("Account.detail", a_number);
	}

	public void update(AccountDTO aDTO) {
		// TODO Auto-generated method stub
		sql.update("Account.update", aDTO);
	}

	public AccountDTO login(AccountDTO aDTO) {
		// TODO Auto-generated method stub
		return sql.selectOne("Account.login", aDTO);
	}

	public int aCount(long c_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("Account.count", c_number);
	}

	public List<AccountDTO> pagingList(Map<String, Integer> pagingParam) {
		// TODO Auto-generated method stub
		return sql.selectList("Account.pList", pagingParam);
	}

}
