package fr.nicolas.jpa.Service;


import java.util.List;

import fr.nicolas.jpa.DAO.OrderDAO;
import fr.nicolas.jpa.Entity.Order;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {

	@Inject 
	OrderDAO orderDAO;
	

	public Order getOrderById(Integer id) {
		return this.orderDAO.find(id);
	}
	
	public List<Order> getAllOrders() {
		return this.orderDAO.getAllOrders();
	}
	
	public void save(Order order) {
		this.orderDAO.save(order);
	}
	
	public void deleteById(Integer id) {
		this.orderDAO.delete(id);
	}
	
}
