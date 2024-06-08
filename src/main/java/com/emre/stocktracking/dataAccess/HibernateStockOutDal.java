package com.emre.stocktracking.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.model.StockOut;

@Transactional
@Repository("stockOutRepository")
public class HibernateStockOutDal implements IStockOut {

	private EntityManager entityManager;
	
	@Autowired
	public HibernateStockOutDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<StockOut> stockOuts() {
		Session session = entityManager.unwrap(Session.class);
		List<StockOut> stockOuts =
				session.createQuery("from StockOut f ORDER BY f.releaseDate DESC", StockOut.class)
				.getResultList();
		return stockOuts;
	}

	@Override
	public void create(StockOut stockOut) {
		entityManager.persist(stockOut);
	}

	@Override
	public StockOut findById(int id) {
		return entityManager.find(StockOut.class, id);
	}

	@Override
	public void delete(int id) {
		entityManager.remove(entityManager.getReference(StockOut.class, id));
	}

	@Override
	public void update(int id, StockOut stockOut) {
		StockOut persistedStock = entityManager.find(StockOut.class, id);
		persistedStock.setPrice(stockOut.getPrice());
		persistedStock.setReleaseDate(stockOut.getReleaseDate());
		persistedStock.setCustomer(stockOut.getCustomer());
		persistedStock.setProduct(stockOut.getProduct());
		persistedStock.setQuantity(stockOut.getQuantity());
		entityManager.merge(persistedStock);
	}

	@Override
	public void deleteByCustomer(int customerId) {
		entityManager.createQuery("delete from StockOut where customer.id = :customerId")
								.setParameter("customerId", customerId).executeUpdate();
	}

	@Override
	public void deleteByProduct(Long barcodeId) {
		entityManager.createQuery("delete from StockOut where product.barcodeId = :barcodeId")
		.setParameter("barcodeId", barcodeId).executeUpdate();
	}
}