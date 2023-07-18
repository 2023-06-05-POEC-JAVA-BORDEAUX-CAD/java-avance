package fr.groupe3.tpfilrouge.clients;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {

	@Inject
	private ClientDao clientDao;

	// pour sauvegarder le client
	public Client save(Client client) {

		System.out.println("Sauvegarde de : " + client);

		return this.clientDao.save(client);

	}

	// pour récupérer un client par son Id
	public Client load(Long id) {

		System.out.println("Chargement du client avec id : " + id);
		Client client = this.clientDao.load(id);

		if (client == null) {
			System.out.println("Aucun client trouvé");
		} else {
			System.out.println("Le client trouvé est : " + client);
		}

		return client;

	}

	public void delete(Client client) {
		if (client == null) {
			return;
		}
		this.clientDao.delete(client.getId());
	}

	public List<Client> findAll() {

		return clientDao.findAll();
	}

	

	public Client getById(Long id) {
		System.out.println("Chargement de client avec id : " + id);
		Client client = this.clientDao.load(id);
		if(client == null) {
				System.out.println("Aucun client trouvé");
		}else {
				System.out.println("Le client trouvé est : " + client);
		}
		return client;
}

}
