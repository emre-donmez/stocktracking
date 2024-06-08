package com.emre.stocktracking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.emre.stocktracking.controller.ICustomerService;
import com.emre.stocktracking.controller.IStockOutService;
import com.emre.stocktracking.controller.IStockInService;
import com.emre.stocktracking.controller.ISupplierService;
import com.emre.stocktracking.controller.IProductService;
import com.emre.stocktracking.model.Customer;
import com.emre.stocktracking.model.StockOut;
import com.emre.stocktracking.model.StockIn;
import com.emre.stocktracking.model.Supplier;
import com.emre.stocktracking.model.Product;

@RequestMapping("/admin")
@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

	private ICustomerService customerService;
	private ISupplierService supplierService;
	private IStockInService stockInService;
	private IStockOutService stockOutService;
	private IProductService productService;
	
	
	@Autowired
	public AdminController(ICustomerService customerService, ISupplierService supplierService,
						   IStockInService stockInService, IStockOutService stockOutService, IProductService productService) {
		this.customerService = customerService;
		this.supplierService = supplierService;
		this.stockInService = stockInService;
		this.stockOutService = stockOutService;
		this.productService = productService;
	}

	@GetMapping
	public ModelAndView editPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stockIns", stockInService.stockIns());
		modelAndView.addObject("stockOuts", stockOutService.stockOuts());
		modelAndView.addObject("products", productService.products());
		modelAndView.addObject("suppliers", supplierService.suppliers());
		modelAndView.addObject("customers", customerService.customers());
		modelAndView.setViewName("admin/index");
		return modelAndView;
	}
	
	@GetMapping("delete/customer/{id}")
	public String customerDelete(@PathVariable int id) {
		stockOutService.deleteByCustomer(id);
		customerService.delete(id);
		return "redirect:/admin";
	}
	
	@GetMapping("update/customer/{id}")
	public String customerUpdate(@PathVariable int id,ModelMap modelMap) {
		Customer customer = customerService.findById(id);
		modelMap.put("customer", customer);
		return "admin/customer-edit";
	}
	
	@PostMapping("update/customer/{id}")
	public String customerSubmit(@ModelAttribute Customer customer, @PathVariable int id) {
		customerService.update(id,customer);
		return "redirect:/admin";
	}
	
	@GetMapping("delete/supplier/{id}")
	public String supplierDelete(@PathVariable int id) {
		stockInService.deleteBySupplier(id);
		supplierService.delete(id);
		return "redirect:/admin";
	}
	
	@GetMapping("update/supplier/{id}")
	public String supplierUpdate(@PathVariable int id, ModelMap modelMap) {
		Supplier supplier = supplierService.findById(id);
		modelMap.put("supplier", supplier);
		return "admin/supplier-edit";
	}
	
	@PostMapping("update/supplier/{id}")
	public String supplierSubmit(@ModelAttribute Supplier supplier, @PathVariable int id) {
		supplierService.update(id, supplier);
		return "redirect:/admin";
	}
	
	@GetMapping("delete/product/{id}")
	public String productDelete(@PathVariable Long id) {
		stockInService.deleteByProduct(id);
		stockOutService.deleteByProduct(id);
		productService.delete(id);
		return "redirect:/admin";
	}
	
	@GetMapping("update/product/{id}")
	public String updateProduct(@PathVariable Long id,ModelMap modelMap ) {
		Product product = productService.findById(id);
		modelMap.put("product", product);
		return "admin/product-edit";
	}
	
	@PostMapping("update/product/{id}")
	public String productSubmit(@ModelAttribute Product product, @PathVariable Long id) {
		productService.update(id, product);
		return "redirect:/admin";
	}
	
	@GetMapping("delete/stockin/{id}")
	public String stokInDelete(@PathVariable int id) {
		stockInService.delete(id);
		return "redirect:/admin";
	}
	
	@GetMapping("update/stockin/{id}")
	public String stokInUpdate(@PathVariable int id, ModelMap modelMap) {
		StockIn stockIn = stockInService.findById(id);
		modelMap.put("stockin", stockIn);
		modelMap.put("products", productService.products());
		modelMap.put("suppliers", supplierService.suppliers());
		return "admin/stock-in-edit";
	}
	
	@PostMapping("update/stockin/{id}")
	public String stokInSubmit(@ModelAttribute StockIn stokIn, @PathVariable int id) {
		stockInService.update(id, stokIn);
		return "redirect:/admin";
	}
	
	@GetMapping("delete/stockout/{id}")
	public String stokOutDelete(@PathVariable int id) {
		stockOutService.delete(id);
		return "redirect:/admin";
	}
	
	@GetMapping("update/stockout/{id}")
	public String stokOutUpdate(@PathVariable int id, ModelMap modelMap) {
		StockOut stockOut = stockOutService.findById(id);
		modelMap.put("stockout", stockOut);
		modelMap.put("products", productService.products());
		modelMap.put("customers", customerService.customers());
		return "admin/stock-out-edit";
	}
	
	@PostMapping("update/stockout/{id}")
	public String stokOutSubmit(@ModelAttribute StockOut stokOut, @PathVariable int id, BindingResult bindingResult) {
		stockOutService.update(id, stokOut);
		return "redirect:/admin";
	}
	
	
}
