package tp.projetfilrouge.service;

import java.util.List;
import java.util.ArrayList;
import jakarta.ejb.Stateless;
import tp.projetfilrouge.pojo.Order;

@Stateless
public class OrderService {
	public static Order getById(Integer id) {
		return new Order();
	}

	public static List<Order> getAll() {
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
