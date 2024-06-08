package com.emre.stocktracking.controller;

import java.util.List;

import com.emre.stocktracking.model.StockOut;

public interface IStockOutService {
	List<StockOut> stockOuts();
	void create(StockOut stockOut);
	StockOut findById(int id);
	void delete(int id);
	void update(int id, StockOut stockOut);
	void deleteByCustomer(int customerId);
	void deleteByProduct(Long barcodeId);
}
