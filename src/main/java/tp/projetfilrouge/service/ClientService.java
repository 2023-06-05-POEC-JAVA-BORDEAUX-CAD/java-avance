package tp.projetfilrouge.service;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import jakarta.ejb.Stateless;
import java.sql.SQLException;
import tp.projetfilrouge.pojo.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Stateless
public class ClientService extends DatabaseService {
	public ClientService() throws SQLException {
		super();
	}

	public Client getById(Integer id) throws SQLException {
		// SELECT * FROM `pfr`.`clients` WHERE `pfr`.`clients`.`id` = 1
		Client client = new Client();
		ResultSet result = db.executeQuery("SELECT * FROM `pfr`.`clients` WHERE `pfr`.`clients`.`id` = " + id);
		if (result.next()) {
			client.setId(result.getInt("id"));
			client.setCompanyName(result.getString("company_name"));
			client.setFirstName(result.getString("first_name"));
			client.setLastName(result.getString("last_name"));
			client.setEmail(result.getString("email"));
			client.setPhone(result.getInt("phone"));
			client.setAdress(result.getString("address"));
			client.setZipCode(result.getString("zip_code"));
			client.setCity(result.getString("city"));
			client.setCountry(result.getString("country"));
			client.setState(result.getInt("state"));
			return client;
		} else {
			return null;
		}
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

	public static String toJson(Client client) throws JsonProcessingException {
		ObjectMapper Jackson = new ObjectMapper();
		String JacksonClient = Jackson.writeValueAsString(client);
		return JacksonClient;
	}

	public static String toJson(List<Client> clients) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(clients);
	}
}
