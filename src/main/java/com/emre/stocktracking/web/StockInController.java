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

import com.emre.stocktracking.controller.IStockInService;
import com.emre.stocktracking.controller.ISupplierService;
import com.emre.stocktracking.controller.IProductService;
import com.emre.stocktracking.model.StockIn;
import com.emre.stocktracking.model.Product;

@Controller
public class StockInController {

	private IStockInService stockInService;
	private IProductService productService;
	private ISupplierService supplierService;
	
	@Autowired
	public StockInController(IStockInService stockInService, IProductService productService,
							 ISupplierService supplierService) {
		this.stockInService = stockInService;
		this.productService = productService;
		this.supplierService = supplierService;
	}

	@RequestMapping("/stockin")
	public ModelAndView stockInPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stockins", stockInService.stockIns());
		modelAndView.addObject("product",  new Product());
		modelAndView.addObject("stockin", new StockIn());
		modelAndView.addObject("suppliers", supplierService.suppliers());
		modelAndView.addObject("products", productService.products());
		modelAndView.setViewName("stockin");
		return modelAndView;
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(@ModelAttribute("product") @Valid Product product,
			BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errormessage", "An error occurred. The product could not be added.");
			return "redirect:stockin";
		}
		productService.create(product);
		redirectAttributes.addFlashAttribute("message", "A product with barcode number " + product.getBarcodeId() + " has been added.");
		return "redirect:stockin";
	}
	
	@PostMapping("/savestockin")
	public String saveStockIn(@ModelAttribute("stockin") @Valid StockIn stockIn,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errormessage", "An error occurred. The stock in could not be added.");
			return "redirect:stockin";
		}
		stockIn.setEntryDate(new Date(System.currentTimeMillis()));
		stockInService.create(stockIn);
		redirectAttributes.addFlashAttribute("message", "The stock of the product with barcode " +stockIn.getProduct().getBarcodeId() + " has been issued.");
		return "redirect:stockin";
	}
	
}
