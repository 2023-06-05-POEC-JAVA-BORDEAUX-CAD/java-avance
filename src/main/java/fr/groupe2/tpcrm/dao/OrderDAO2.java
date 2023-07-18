package fr.groupe2.tpcrm.dao;

import fr.groupe2.tpcrm.model.Order2;
import jakarta.ejb.Stateless;

import java.util.Map;
import java.util.HashMap;

@Stateless
public class OrderDAO2 {
	
	private Map<Integer, Order2> orders = new HashMap<>();
	
	public OrderDAO2() {
		this.orders.put(1, new Order2(1, "Formation", "Angular init",2, 3, 1200, 0));
		this.orders.put(2, new Order2(2, "Formation", "React avancé",2, 3, 1000, 2));
		this.orders.put(3, new Order2(3, "Coaching", "React Techlead",1, 20, 900, 2));
		this.orders.put(4, new Order2(4, "Coaching", "Nest.js Techlead",1, 50, 800, 1));
	}

	public Order2 getOrderById(Integer id) {
		return this.orders.get(id); 
	}
	
	public Map<Integer, Order2> getOrders(){
		return this.orders;
	}
	
}
