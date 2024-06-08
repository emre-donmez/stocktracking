package com.emre.stocktracking.dataAccess;

import java.util.List;

import com.emre.stocktracking.model.Product;

public interface IProduct {
	void create(Product product);
	List <Product> products();
	Product findById(Long id);
	void delete(Long id);
	void update(Long id, Product product);
}
