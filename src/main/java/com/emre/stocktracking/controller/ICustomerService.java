package com.emre.stocktracking.controller;

import java.util.List;

import com.emre.stocktracking.model.Customer;

public interface ICustomerService {
	List<Customer> customers();
	Customer findById(int id);
	void create(Customer customer);
	void delete(int id);
	void update(int id , Customer customer);
}
