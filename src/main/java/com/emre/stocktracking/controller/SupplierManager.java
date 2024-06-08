package com.emre.stocktracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.dataAccess.ISupplier;
import com.emre.stocktracking.model.Supplier;

@Service
@Transactional
public class SupplierManager implements ISupplierService {

	private ISupplier supplierRepository;
	
	@Autowired
	public SupplierManager(ISupplier supplier) {
		this.supplierRepository = supplier;
	}

	@Override
	public List<Supplier> suppliers() {
		return supplierRepository.suppliers();
	}

	@Override
	public void create(Supplier supplier) {
		supplierRepository.create(supplier);
	}

	@Override
	public Supplier findById(int id) {
		return supplierRepository.findById(id);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void delete(int id) {
		supplierRepository.delete(id);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void update(int id, Supplier supplier) {
		supplierRepository.update(id, supplier);
	}

}
