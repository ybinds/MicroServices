package com.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.StockInfo;

public interface StockInfoRepository extends JpaRepository<StockInfo, Serializable> {

}
