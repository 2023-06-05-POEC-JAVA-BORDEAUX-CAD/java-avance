package tp.projetfilrouge.service;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import jakarta.ejb.Stateless;
import java.sql.SQLException;
import tp.projetfilrouge.Pojo.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Stateless
public class ClientService extends DatabaseService {
	public ClientService() throws SQLException {
		super();
	}

	public Client getById(Integer id) {
		// SELECT * FROM `pfr`.`clients` WHERE `pfr`.`clients`.`id` = 1
		return new Client();
	}

	public List<Client> getAll() throws SQLException {
		// SELECT * FROM `pfr`.`clients`
		List<Client> clients = new ArrayList<Client>();

		ResultSet result = db.executeQuery("SELECT * FROM `pfr`.`clients`");
		while (result.next()) {
			Client cli = new Client();
			cli.setId(result.getInt("id"));
			cli.setCompanyName(result.getString("company_name"));
			cli.setFirstName(result.getString("first_name"));
			cli.setLastName(result.getString("last_name"));
			cli.setEmail(result.getString("email"));
			cli.setPhone(result.getInt("phone"));
			cli.setAdress(result.getString("address"));
			cli.setZipCode(result.getString("zip_code"));
			cli.setCity(result.getString("city"));
			cli.setCountry(result.getString("country"));
			cli.setState(result.getInt("state"));
			clients.add(cli);
		}
		return clients;
	}

	public static String toJson(Client client) {
		return "{}";
	}

	public static String toJson(List<Client> clients) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(clients);
	}
}
