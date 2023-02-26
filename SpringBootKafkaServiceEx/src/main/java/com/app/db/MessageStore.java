package com.app.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.entity.StockInfo;
import com.app.repository.StockInfoRepository;
import com.app.util.JsonUtil;

@Component
public class MessageStore {

	@Autowired
	private StockInfoRepository repo;
	
	public void add(String message) {
		StockInfo si = JsonUtil.convertToObj(message);
		repo.save(si);
	}

	public List<StockInfo> getAll() {
		return repo.findAll();
	}
}
