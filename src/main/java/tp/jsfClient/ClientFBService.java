package tp.jsfClient;

import jakarta.ejb.Stateless;
import tp.projetfilrouge.pojo.Client;

@Stateless
public class ClientFBService {

	public void save(Client client) {
		// sauvegarde du client
		System.out.println(client);
	}

	public Client load(String id) {
		Integer realId = Integer.parseInt(id);
		Client client = new Client();
		client.setId(realId);
		client.setLastName("Lastname");
		return client;
	}
}
