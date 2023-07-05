package tp.projetfilrouge.service;

import java.util.List;
import java.util.ArrayList;
import jakarta.ejb.Stateless;
import tp.projetfilrouge.pojo.Client;

@Stateless
public class ClientService {
	public static Client getById(Integer id) {
		return new Client();
	}

	public static List<Client> getAll() {
		List<Client> clients = new ArrayList<Client>();
		clients.add(new Client());
		clients.add(new Client());
		clients.add(new Client());
		clients.add(new Client());
		return clients;
	}

	public static String toJson(Client client) {
		return "{}";
	}

	public static String toJson(List<Client> clients) {
		return "[{},{},{}]";
	}
}
