package fr.groupe2.tpcrm.dao;

import fr.groupe2.tpcrm.model.Order;
import jakarta.ejb.Stateless;

import java.util.Map;
import java.util.HashMap;

@Stateless
public class OrderDAO {
	
	private Map<Integer, Order> orders = new HashMap<>();
	
	public OrderDAO() {
		this.orders.put(1, new Order(1, "Formation", "Angular init", 3, 1200, 0));
		this.orders.put(2, new Order(2, "Formation", "React avancé", 3, 1000, 2));
		this.orders.put(3, new Order(3, "Coaching", "React Techlead", 20, 900, 2));
		this.orders.put(4, new Order(4, "Coaching", "Nest.js Techlead", 50, 800, 1));
	}

	public Order getOrderById(Integer id) {
		return this.orders.get(id); 
	}
	
	public Map<Integer, Order> getOrders(){
		return this.orders;
	}
	
}
