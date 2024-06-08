package com.emre.stocktracking.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emre.stocktracking.model.StockStatus;

@Transactional
@Repository("stockStatusRepository")
public class HibernateStatusDal implements IStockStatus {
	
	private EntityManager entityManager;

	@Autowired
	public HibernateStatusDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<StockStatus> stockStatus(){
		Session session = entityManager.unwrap(Session.class);
		List<StockStatus> stockStatus =
				session.createQuery("from StockStatus", StockStatus.class)
				.getResultList();
		return stockStatus;
		
	}
	
	
}
