package com.emre.stocktracking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.emre.stocktracking.controller.IStockStatusService;

@Controller
public class StockStatusController {
	
	private IStockStatusService stockStatusService;

	@Autowired
	public StockStatusController(IStockStatusService stockStatusService) {
		this.stockStatusService = stockStatusService;
	}


	@RequestMapping(value={"/","/index.html"})
	public ModelAndView stockStatusPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stockStatus", stockStatusService.stockStatuses());
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
