package com.emre.stocktracking.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.model.Supplier;

@Transactional
@Repository("supplierRepository")
public class HibernateSupplierDal implements ISupplier {
	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateSupplierDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Supplier> suppliers() {
		Session session = entityManager.unwrap(Session.class);
		List<Supplier> suppliers = session.createQuery("from Supplier", Supplier.class)
				.getResultList();
		return suppliers;
	}

	@Override
	public void create(Supplier supplier) {
		entityManager.persist(supplier);
	}

	@Override
	public Supplier findById(int id) {
		return entityManager.find(Supplier.class, id);
	}

	@Override
	public void delete(int id) {
		entityManager.remove(entityManager.getReference(Supplier.class, id));
	}

	@Override
	public void update(int id, Supplier supplier) {
		Supplier persistedSupplier = entityManager.find(Supplier.class, id);
		persistedSupplier.setAddress(supplier.getAddress());
		persistedSupplier.setEmail(supplier.getEmail());
		persistedSupplier.setFaxNumber(supplier.getFaxNumber());
		persistedSupplier.setCompany(supplier.getCompany());
		persistedSupplier.setPhone(supplier.getPhone());
		entityManager.merge(persistedSupplier);
	}
}