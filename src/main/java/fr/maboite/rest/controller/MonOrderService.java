package fr.maboite.rest.controller;

import fr.maboite.jpa.OrderDao;
import fr.maboite.jpa.OrderJpa;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class MonOrderService {

	@Inject
	private OrderDao orderDao;
	
	public OrderJpa load(Integer id) {

		return this.orderDao.load(id);

	}
	
	public OrderJpa save(OrderJpa orderJpa) {
		
		return this.orderDao.save(orderJpa);
	}

	
}
