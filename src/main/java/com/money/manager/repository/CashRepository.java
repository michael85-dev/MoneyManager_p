package com.money.manager.repository;

import java.util.List;
import java.util.Map;

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

	public void create(CashDTO sDTO) {
		// TODO Auto-generated method stub
		sql.insert("Cash.create", sDTO);
	}

	public void delete(long s_number) {
		// TODO Auto-generated method stub
		sql.delete("Cash.delete", s_number);
	}

	public CashDTO detail(long s_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("Cash.detail", s_number);
	}

	public void update(CashDTO sDTO) {
		// TODO Auto-generated method stub
		sql.update("Cash.update", sDTO);
	}

	public List<CashDTO> pagingList(Map<String, Integer> pagingParam) {
		// TODO Auto-generated method stub
		return sql.selectList("Cash.pList", pagingParam);
	}

	public int sCount(long c_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("Cash.count", c_number);
	}

}
