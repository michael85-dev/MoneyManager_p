package com.money.manager.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.money.manager.dto.AccountInfoDTO;

@Repository
public class AccountInfoRepository {
	@Autowired
	private SqlSessionTemplate sql;
	
	public List<AccountInfoDTO> findAll(long a_number) {
		// TODO Auto-generated method stub
		return sql.selectList("AccountInfo.findAll", a_number);
	}

	public void create(AccountInfoDTO aiDTO) {
		// TODO Auto-generated method stub
		sql.insert("AccountInfo.create", aiDTO);
	}

	public List<AccountInfoDTO> pagingList(Map<String, Integer> pagingParam) {
		// TODO Auto-generated method stub
		return sql.selectList("AccountInfo.pList", pagingParam);
	}

	public int aiCount(long a_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("AccountInfo.count", a_number);
	}

	public AccountInfoDTO detail(long ai_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("AccountInfo.detail", ai_number);
	}

	public void update(AccountInfoDTO aiDTO) {
		// TODO Auto-generated method stub
		sql.update("AccountInfo.update", aiDTO);
	}

}
