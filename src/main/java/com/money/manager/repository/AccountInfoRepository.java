package com.money.manager.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.money.manager.dto.AccountInfoDTO;

@Repository
public class AccountInfoRepository {
	@Autowired
	private SqlSessionTemplate sql;
	
	public List<AccountInfoDTO> detail(long a_number) {
		// TODO Auto-generated method stub
		return sql.selectList("AccountInfo.detail", a_number);
	}

	public void create(AccountInfoDTO aiDTO) {
		// TODO Auto-generated method stub
		sql.insert("AccountInfo.create", aiDTO);
	}

}