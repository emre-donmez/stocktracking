package com.emre.stocktracking.web;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emre.stocktracking.controller.ICustomerService;
import com.emre.stocktracking.controller.IStockOutService;
import com.emre.stocktracking.controller.IProductService;
import com.emre.stocktracking.model.StockOut;

@Controller
public class StockOutController {
	
	private IStockOutService stockOutService;
	private ICustomerService customerService;
	private IProductService productService;

	@Autowired
	public StockOutController(IStockOutService stockOutService, ICustomerService customerService,
							  IProductService productService) {
		this.stockOutService = stockOutService;
		this.customerService = customerService;
		this.productService = productService;
	}


	@RequestMapping("/stockout")
	public ModelAndView stockOutPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stockouts", stockOutService.stockOuts());
		modelAndView.addObject("stockout", new StockOut());
		modelAndView.addObject("customers", customerService.customers());
		modelAndView.addObject("products", productService.products());
		modelAndView.setViewName("stockout");
		return modelAndView;
	}
	
	@PostMapping("/saveout")
	public String saveOut(@ModelAttribute("stockout") @Valid StockOut stockOut,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errormessage", "An error occurred. The stock out could not be added.");
			return "redirect:stockout";
		}
		stockOut.setReleaseDate(new Date(System.currentTimeMillis()));
		stockOutService.create(stockOut);
		redirectAttributes.addFlashAttribute("message", "The stock of the product with barcode " +stockOut.getProduct().getBarcodeId() + " has been issued.");
		return "redirect:stockout";
	}
	
}
