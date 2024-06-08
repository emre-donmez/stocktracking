package com.emre.stocktracking.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.model.Product;

@Transactional
@Repository("productRepository")
public class HibernateProductDal implements IProduct {

	private EntityManager entityManager;
	
	@Autowired
	public HibernateProductDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Product product) {
		entityManager.persist(product);
	}

	@Override
	public List<Product> products() {
		Session session = entityManager.unwrap(Session.class);
		List<Product> products= session.createQuery("from Product", Product.class)
				.getResultList();
		return products;
	}

	@Override
	public Product findById(Long id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(Product.class, id));;
	}

	@Override
	public void update(Long id, Product product) {
		Product persistedProduct = entityManager.find(Product.class, id);
		persistedProduct.setName(product.getName());
		entityManager.merge(persistedProduct);
	}
}
