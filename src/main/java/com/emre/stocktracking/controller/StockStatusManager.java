package com.emre.stocktracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.dataAccess.IStockStatus;
import com.emre.stocktracking.model.StockStatus;

@Service
@Transactional
public class StockStatusManager implements IStockStatusService {

	private IStockStatus stockStatusRepository;
	
	@Autowired
	public StockStatusManager(IStockStatus stockStatus) {
		this.stockStatusRepository = stockStatus;
	}

	@Override
	public List<StockStatus> stockStatuses() {
		return stockStatusRepository.stockStatus();
	}
		
	
	
}
