package com.emre.stocktracking.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.model.Customer;

@Transactional
@Repository("customerRepository")
public class HibernateCustomerDal implements ICustomer {

	private EntityManager entityManager;
	
	@Autowired
	public HibernateCustomerDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Customer> customers() {
		Session session = entityManager.unwrap(Session.class);
		List<Customer> customers = session.createQuery("from Customer", Customer.class)
				.getResultList();
		return customers;
	}

	@Override
	public void create(Customer customer) {
		entityManager.persist(customer);
	}

	@Override
	public void delete(int id) {
		entityManager.remove(entityManager.getReference(Customer.class, id));
	}

	@Override
	public void update(int id, Customer customer) {
		Customer persistedCustomer = entityManager.find(Customer.class, id);
		persistedCustomer.setAddress(customer.getAddress());
		persistedCustomer.setEmail(customer.getEmail());
		persistedCustomer.setFaxNumber(customer.getFaxNumber());
		persistedCustomer.setCompany(customer.getCompany());
		persistedCustomer.setPhone(customer.getPhone());
		entityManager.merge(persistedCustomer);
	}

	@Override
	public Customer findById(int id) {
		return entityManager.find(Customer.class, id);
	}

}
