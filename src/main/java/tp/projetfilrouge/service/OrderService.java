package tp.projetfilrouge.service;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import jakarta.ejb.Stateless;
import java.sql.SQLException;

import tp.projetfilrouge.pojo.Client;
import tp.projetfilrouge.pojo.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Stateless
public class OrderService extends DatabaseService {

	public OrderService() throws SQLException {
		super();
	}

	public Order getById(Integer id) {
		return new Order();
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

	public static String toJson(Order order) {
		return "{}";
	}

	public static String toJson(List<Order> orders) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(orders);
	}

}
