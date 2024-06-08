package com.emre.stocktracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.dataAccess.IStockOut;
import com.emre.stocktracking.model.StockOut;

@Service
@Transactional
public class StockOutManager implements IStockOutService {

	private IStockOut stockOutRepository;

	@Autowired
	public StockOutManager(IStockOut stockOut) {
		this.stockOutRepository = stockOut;
	}
	
	@Override
	public List<StockOut> stockOuts() {
		return stockOutRepository.stockOuts();
	}

	@Override
	public void create(StockOut stockOut) {
		stockOutRepository.create(stockOut);
	}

	@Override
	public StockOut findById(int id) {
		return stockOutRepository.findById(id);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void delete(int id) {
		stockOutRepository.delete(id);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void update(int id, StockOut stockOut) {
		stockOutRepository.update(id, stockOut);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void deleteByCustomer(int customerId) {
		stockOutRepository.deleteByCustomer(customerId);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void deleteByProduct(Long barcodeId) {
		stockOutRepository.deleteByProduct(barcodeId);
	}
}
