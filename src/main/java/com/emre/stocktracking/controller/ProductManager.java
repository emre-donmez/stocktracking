package com.emre.stocktracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.dataAccess.IProduct;
import com.emre.stocktracking.model.Product;

@Service
@Transactional
public class ProductManager implements IProductService {

	private IProduct productRepository;
	
	@Autowired
	public ProductManager(IProduct productRepository) {
		this.productRepository = productRepository;
	}


	@Override
	public void create(Product product) {
		productRepository.create(product);
	}


	@Override
	public List<Product> products() {
		return productRepository.products();
	}


	@Override
	public Product findById(Long id) {
		return productRepository.findById(id);
	}


	@Override
	@Secured("ROLE_ADMIN")
	public void delete(Long id) {
		productRepository.delete(id);
	}


	@Override
	@Secured("ROLE_ADMIN")
	public void update(Long id, Product product) {
		productRepository.update(id, product);
	}

}
