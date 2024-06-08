package com.emre.stocktracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.emre.stocktracking.dataAccess.IStockIn;
import com.emre.stocktracking.model.StockIn;

@Service
@Transactional
public class StockInManager implements IStockInService {

	private IStockIn stockInRepository;

	@Autowired
	public StockInManager(IStockIn stockIn) {
		this.stockInRepository = stockIn;
	}

	@Override
	public List<StockIn> stockIns() {
		return stockInRepository.stockIns();
	}

	@Override
	public void create(StockIn stockIn) {
		stockInRepository.create(stockIn);
	}

	@Override
	public StockIn findById(int id) {
		return stockInRepository.findById(id);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void delete(int id) {
		stockInRepository.delete(id);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void update(int id, StockIn stockIn) {
		stockInRepository.update(id, stockIn);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void deleteBySupplier(int supplierId) {
		stockInRepository.deleteBySupplier(supplierId);
	}

	@Override
	@Secured(value = "ROLE_ADMIN")
	public void deleteByProduct(Long barcodeId) {
		stockInRepository.deleteByProduct(barcodeId);
	}
	

}
