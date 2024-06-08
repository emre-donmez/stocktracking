package com.emre.stocktracking.dataAccess;

import java.util.List;

import com.emre.stocktracking.model.Supplier;

public interface ISupplier {
	List<Supplier> suppliers();
	Supplier findById(int id);
	void delete(int id);
	void create(Supplier supplier);
	void update(int id, Supplier supplier);
}
