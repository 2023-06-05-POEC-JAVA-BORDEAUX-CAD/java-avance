package fr.maboite.correction.service;

import fr.maboite.correction.jpa.dao.OrderJpaDao;
import fr.maboite.correction.jpa.model.Order;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {

	@Inject
	private OrderJpaDao orderJpaDao;
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	public Order save(Order order) {
		
		
		
		return orderJpaDao.save(order);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Order load(int id) {
		return orderJpaDao.find(id);
	}
	
	
	public void deleteById(int id) {
		Order OrderToDelete = orderJpaDao.find(id);
		System.out.println("suppression order: id " + OrderToDelete.getId() + " designation = " + OrderToDelete.getDesignation()  );
		orderJpaDao.delete(id);
	}
}
