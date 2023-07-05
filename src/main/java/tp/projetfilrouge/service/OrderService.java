package tp.projetfilrouge.service;

import java.util.List;
import java.util.ArrayList;
import jakarta.ejb.Stateless;
import tp.projetfilrouge.pojo.Order;

@Stateless
public class OrderService {
	public Order getById(Integer id) {
		return new Order();
	}

	public List<Order> getAll() {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order());
		orders.add(new Order());
		orders.add(new Order());
		orders.add(new Order());
		return orders;
	}

	public static String toJson(Order order) {
		return "{}";
	}

	public static String toJson(List<Order> orders) {
		return "[{},{},{}]";
	}

}
