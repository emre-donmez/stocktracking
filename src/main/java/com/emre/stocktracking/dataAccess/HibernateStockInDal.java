package com.emre.stocktracking.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.model.StockIn;

@Transactional
@Repository("stockInRepository")
public class HibernateStockInDal implements IStockIn {

	private EntityManager entityManager;
	
	@Autowired
	public HibernateStockInDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<StockIn> stockIns() {
		Session session = entityManager.unwrap(Session.class);
		List<StockIn> stockIns =
				session.createQuery("from StockIn f ORDER BY f.entryDate DESC", StockIn.class)
				.getResultList();
		return stockIns;
	}

	@Override
	public void create(StockIn stockIn) {
		entityManager.persist(stockIn);
	}

	@Override
	public StockIn findById(int id) {
		return entityManager.find(StockIn.class, id);
	}

	@Override
	public void delete(int id) {
		entityManager.remove(entityManager.getReference(StockIn.class, id));
	}

	@Override
	public void update(int id, StockIn stockIn) {
		StockIn persistedStock = entityManager.find(StockIn.class, id);
		persistedStock.setPrice(stockIn.getPrice());
		persistedStock.setEntryDate(stockIn.getEntryDate());
		persistedStock.setSupplier(stockIn.getSupplier());
		persistedStock.setProduct(stockIn.getProduct());
		persistedStock.setQuantity(stockIn.getQuantity());
		entityManager.merge(persistedStock);
	}

	@Override
	public void deleteBySupplier(int supplierId) {
		entityManager.createQuery("delete from StockIn where supplier.id = :supplierId")
		.setParameter("supplierId", supplierId).executeUpdate();
	}

	@Override
	public void deleteByProduct(Long barcodeId) {
		entityManager.createQuery("delete from StockIn where product.barcodeId = :barcodeId")
		.setParameter("barcodeId", barcodeId).executeUpdate();
	}	

}
