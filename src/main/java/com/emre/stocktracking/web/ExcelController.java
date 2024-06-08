package com.emre.stocktracking.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.emre.stocktracking.controller.ExcelFileService;
import com.emre.stocktracking.controller.ICustomerService;
import com.emre.stocktracking.controller.IStockOutService;
import com.emre.stocktracking.controller.IStockStatusService;
import com.emre.stocktracking.controller.IStockInService;
import com.emre.stocktracking.controller.ISupplierService;
import com.emre.stocktracking.model.Customer;
import com.emre.stocktracking.model.StockOut;
import com.emre.stocktracking.model.StockStatus;
import com.emre.stocktracking.model.StockIn;
import com.emre.stocktracking.model.Supplier;

@Controller
public class ExcelController {

	private ICustomerService customerService;
	private ISupplierService supplierService;
	private IStockInService stockInService;
	private IStockOutService stockOutService;
	private ExcelFileService excelFileService;
	private IStockStatusService stockStatusService;
	
	@Autowired
	public ExcelController(ICustomerService customerService, ISupplierService supplierService,
						   IStockInService stockInService, IStockOutService stockOutService, ExcelFileService excelFileService,
						   IStockStatusService stockStatusService) {
		this.customerService = customerService;
		this.supplierService = supplierService;
		this.stockInService = stockInService;
		this.stockOutService = stockOutService;
		this.excelFileService = excelFileService;
		this.stockStatusService = stockStatusService;
	}
	
	@GetMapping("/excel")
	public void downloadExcelFile(HttpServletResponse httpServletResponse) throws IOException {
		
		List<StockStatus> stockStatuses = stockStatusService.stockStatuses();
		List<StockIn> stockIns = stockInService.stockIns();
		List<StockOut> stockOuts = stockOutService.stockOuts();
		List<Customer> customers = customerService.customers();
		List<Supplier> suppliers = supplierService.suppliers();
		
				
		ByteArrayInputStream byteArrayInputStream = excelFileService.export(stockStatuses,stockIns,stockOuts,customers,suppliers);
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateTime = dateFormatter.format(new Date());
         
		httpServletResponse.setContentType("application/octet-stream");
		httpServletResponse.setHeader("Content-Disposition", "attachment; filename="+currentDateTime+".xlsx");
        IOUtils.copy(byteArrayInputStream, httpServletResponse.getOutputStream());
	}
	
	
}
