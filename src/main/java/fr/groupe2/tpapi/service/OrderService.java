package fr.groupe2.tpapi.service;

import java.util.List;

import fr.groupe2.tpapi.dao.OrderDao;
import fr.groupe2.tpapi.model.Order;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {

	@Inject 
	OrderDao orderDao;
	

	public Order getOrderById(Integer id) {
		return this.orderDao.find(id);
	}
	
	public List<Order> getAllOrders() {
		return this.orderDao.getAllOrders();
	}
	
	public Order save(Order order) {
		return this.orderDao.save(order);
	}
	
	public void deleteById(Integer id) {
		this.orderDao.delete(id);
	}
	
}
