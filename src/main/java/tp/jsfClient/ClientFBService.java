package tp.jsfClient;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ejb.Stateless;
import tp.projetfilrouge.pojo.Client;
import tp.projetfilrouge.service.ClientService;

@Named
@Stateless
public class ClientFBService {

	@Inject
	ClientService clientService;

	public void save(Client client) {
		// sauvegarde du client
		System.out.println(client);
	}

	public Client load(String id) {
		Client client;
		try {
			Integer realId = Integer.parseInt(id);
			client = clientService.getById(realId);
		} catch (Exception e) {
			return null;
		}
		return client;
	}
}
