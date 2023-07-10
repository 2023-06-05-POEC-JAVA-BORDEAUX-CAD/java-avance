package fr.nicolas.jpa.Service;


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
	
	public void save(Order order) {
		this.orderDAO.save(order);
	}
	
}
