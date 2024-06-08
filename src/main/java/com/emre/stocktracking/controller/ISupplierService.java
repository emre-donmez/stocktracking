package com.emre.stocktracking.controller;

import java.util.List;

import com.emre.stocktracking.model.Supplier;

public interface ISupplierService {
	List<Supplier> suppliers();
	Supplier findById(int id);
	void create(Supplier supplier);
	void delete(int id);
	void update(int id , Supplier supplier);
}
