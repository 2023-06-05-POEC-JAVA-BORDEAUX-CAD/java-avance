package tp.projetfilrouge.service;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import jakarta.ejb.Stateless;
import java.sql.SQLException;
import tp.projetfilrouge.pojo.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Stateless
public class OrderService extends DatabaseService {

	public OrderService() throws SQLException {
		super();
	}

	public Order getById(Integer id) throws SQLException {
		// SELECT * FROM `pfr`.`orders` WHERE `pfr`.`orders`.`id` = 1
		Order order = new Order();
		ResultSet result = db.executeQuery("SELECT * FROM `pfr`.`orders` WHERE `pfr`.`orders`.`id` = " + id);

		if (result.next()) {
			order.setId(result.getInt("id"));
			order.setTypePresta(result.getString("type_presta"));
			order.setClientId(result.getInt("client_id"));
			order.setNbDays(result.getInt("nb_days"));
			order.setUnitPrice(result.getInt("unit_price"));
			order.setState(result.getInt("state"));
			order.setDesignation(result.getString("designation"));
			return order;
		} else {
			System.out.println("pas de commande");
			return null;
		}

	}

	public List<Order> getAll() throws SQLException {
		// SELECT * FROM `pfr`.`clients`
		List<Order> orders = new ArrayList<Order>();
		ResultSet result = db.executeQuery("SELECT * FROM `pfr`.`orders`");
		while (result.next()) {
			Order ord = new Order();
			ord.setId(result.getInt("id"));
			ord.setTypePresta(result.getString("type_presta"));
			ord.setClientId(result.getInt("client_id"));
			ord.setNbDays(result.getInt("nb_days"));
			ord.setUnitPrice(result.getInt("unit_price"));
			ord.setState(result.getInt("state"));
			ord.setDesignation(result.getString("designation"));
			orders.add(ord);
		}
		return orders;
	}

	public static String toJson(Order order) throws JsonProcessingException {
		ObjectMapper jackson = new ObjectMapper();
		return jackson.writeValueAsString(order);
	}

	public static String toJson(List<Order> orders) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(orders);
	}

}
