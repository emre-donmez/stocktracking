package com.emre.stocktracking.web;

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
import com.emre.stocktracking.controller.ISupplierService;
import com.emre.stocktracking.model.Customer;
import com.emre.stocktracking.model.Supplier;

@Controller
public class UserController {

	private ICustomerService customerService;
	private ISupplierService supplierService;

	@Autowired
	public UserController(ICustomerService customerService, ISupplierService supplierService) {
		this.customerService = customerService;
		this.supplierService = supplierService;
	}

	@RequestMapping("/user")
	public ModelAndView userPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customers", customerService.customers());
		modelAndView.addObject("suppliers", supplierService.suppliers());
		modelAndView.addObject("customer", new Customer());
		modelAndView.addObject("supplier", new Supplier());
		modelAndView.setViewName("user");
		return modelAndView;
	}
	
	@PostMapping("/savecustomer")
	public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errormessage", "An error occurred. The company could not be added.");
			return "redirect:user";
		}
		customerService.create(customer);
		redirectAttributes.addFlashAttribute("message",customer.getCompany() + " has been added as a customer." );
		return "redirect:user";
	}
	
	@PostMapping("/savesupplier")
	public String saveSupplier(@ModelAttribute("supplier") @Valid Supplier supplier,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errormessage", "An error occurred. The company could not be added.");
			return "redirect:user";
		}
		supplierService.create(supplier);
		redirectAttributes.addFlashAttribute("message", supplier.getCompany() + " has been added as a supplier.");
		return "redirect:user";
	}
}
