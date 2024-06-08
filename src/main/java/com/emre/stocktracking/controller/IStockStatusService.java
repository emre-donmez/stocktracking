package com.emre.stocktracking.controller;

import java.util.List;

import com.emre.stocktracking.model.StockStatus;

public interface IStockStatusService {
	
	List<StockStatus> stockStatuses();
}
