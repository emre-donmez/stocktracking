package com.emre.stocktracking.dataAccess;

import java.util.List;

import com.emre.stocktracking.model.Customer;

public interface ICustomer {
	List<Customer> customers();
	Customer findById(int id);
	void create(Customer customer);
	void delete(int id);
	void update(int id , Customer customer);
}
