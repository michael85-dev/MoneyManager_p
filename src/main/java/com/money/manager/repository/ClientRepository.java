package com.money.manager.repository;

import java.util.List;
import java.util.Map;

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

	public List<ClientDTO> findAll(long c_number) {
		// TODO Auto-generated method stub
		return sql.selectList("Client.findAll");
	}

	public ClientDTO detail(long c_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("Client.detail", c_number);
	}

	public void update(ClientDTO cDTO) {
		// TODO Auto-generated method stub
		sql.update("Client.update", cDTO);
	}

	public void delete(long c_number) {
		// TODO Auto-generated method stub
		sql.delete("Client.delete", c_number);
	}

	public int cCount() {
		// TODO Auto-generated method stub
		return sql.selectOne("Client.count");
	}

	public List<ClientDTO> pagingList(Map<String, Integer> pagingParam) {
		// TODO Auto-generated method stub
		return sql.selectList("Client.pList", pagingParam);
	}

	public ClientDTO login(ClientDTO cDTO) {
		// TODO Auto-generated method stub
		return sql.selectOne("Client.login", cDTO);
	}

}
