package com.emre.stocktracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.dataAccess.ICustomer;
import com.emre.stocktracking.model.Customer;

@Service
@Transactional
public class CustomerManager implements ICustomerService {

	private ICustomer customerRepository;
	
	@Autowired
	public CustomerManager(ICustomer customer) {
		this.customerRepository = customer;
	}

	@Override
	public List<Customer> customers() {
		return customerRepository.customers();
	}

	@Override
	public void create(Customer customer) {
		customerRepository.create(customer);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void delete(int id) {
		customerRepository.delete(id);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void update(int id, Customer customer) {
		customerRepository.update(id,customer);
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.findById(id);
	}	
	
}
