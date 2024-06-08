package com.emre.stocktracking.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.emre.stocktracking.model.Customer;
import com.emre.stocktracking.model.StockOut;
import com.emre.stocktracking.model.StockStatus;
import com.emre.stocktracking.model.StockIn;
import com.emre.stocktracking.model.Supplier;



public interface ExcelFileService {
	ByteArrayInputStream export(List<StockStatus> stockStatuses,
								List<StockIn> stockIns, List<StockOut> stockOuts,
								List<Customer> customers, List <Supplier> suppliers);
}
