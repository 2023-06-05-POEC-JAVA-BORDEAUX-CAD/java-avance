package fr.maboite.jpa2.client;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {

	@Inject
	private ClientDao clientDao;

	public Client save(Client client) {
		System.out.println("Sauvegarde de : " + client);
		return this.clientDao.save(client);
	}

	public Client load(Integer id) {
		System.out.println("Chargement du client portant l'id: " + id);
		Client target = this.clientDao.load(id);
		System.out.println("Ville : " + target.getCity());
		return this.clientDao.load(id);
	}

}
