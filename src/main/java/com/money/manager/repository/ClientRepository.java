package com.money.manager.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.money.manager.dto.ClientDTO;

public class ClientRepository {
	@Autowired
	private SqlSessionTemplate sql;
	
	public void join(ClientDTO cDTO) {
		// TODO Auto-generated method stub
		sql.insert("Client.join", cDTO);
	}

}
