package com.emre.stocktracking.dataAccess;

import java.util.List;

import com.emre.stocktracking.model.StockIn;

public interface IStockIn {
	List<StockIn> stockIns();
	void create(StockIn stockIn);
	StockIn findById(int id);
	void delete(int id);
	void update(int id, StockIn stockIn);
	void deleteBySupplier(int supplierId);
	void deleteByProduct(Long barcodeId);
}
