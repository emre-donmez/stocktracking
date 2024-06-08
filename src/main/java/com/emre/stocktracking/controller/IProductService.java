package com.emre.stocktracking.controller;

import java.util.List;

import com.emre.stocktracking.model.Product;

public interface IProductService {
	void create (Product product);
	List <Product> products();
	Product findById(Long id);
	void delete(Long id);
	void update(Long id, Product product);
}
