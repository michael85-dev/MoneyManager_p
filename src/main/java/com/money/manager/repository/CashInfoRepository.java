package com.money.manager.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.money.manager.dto.CashInfoDTO;

@Repository
public class CashInfoRepository {
	@Autowired
	private SqlSessionTemplate sql;

	public List<CashInfoDTO> findAll(long s_number) {
		// TODO Auto-generated method stub
		return sql.selectList("CashInfo.findAll", s_number);
	}

	public List<CashInfoDTO> detailList(long s_number) {
		// TODO Auto-generated method stub
		return sql.selectList("CashInfo.detailList", s_number);
	}

	public void create(CashInfoDTO siDTO) {
		// TODO Auto-generated method stub
		sql.insert("CashInfo.create", siDTO);
	}

	public CashInfoDTO detail(long si_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("CashInfo.detail", si_number);
	}

	public List<CashInfoDTO> pagingList(Map<String, Integer> pagingParam) {
		// TODO Auto-generated method stub
		return sql.selectList("CashInfo.pList", pagingParam);
	}

	public int siCount(long s_number) {
		// TODO Auto-generated method stub
		return sql.selectOne("CashInfo.count", s_number);
	}
}
