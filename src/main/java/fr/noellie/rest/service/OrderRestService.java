package fr.noellie.rest.service;

import fr.noellie.jpa.dao.OrderJPADao;
import fr.noellie.jpa.model.OrderJPA;
import jakarta.inject.Inject;

public class OrderRestService {
	@Inject
	private OrderJPADao orderDao;
	
	public OrderJPA load(Long id) {
		return this.orderDao.load(id);
	}
	
	public OrderJPA save(OrderJPA orderJPA) {
		return this.orderDao.save(orderJPA);
	}
}
