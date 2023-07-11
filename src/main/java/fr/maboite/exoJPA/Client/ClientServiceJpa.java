package fr.maboite.exoJPA.Client;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientServiceJpa {
	
	@Inject
	private ClientJpaDao clientJpaDao;
	

	public ClientEntity save(ClientEntity client) {
		System.out.println("Sauvegarde de : " + client);
		return this.clientJpaDao.save(client);
	}
	

	public ClientEntity load(Integer integer) {
		System.out.println("Chargement de client avec id : " + integer);
		ClientEntity client = this.clientJpaDao.load(integer);
		if(client == null) {
			System.out.println("Aucun client trouvé");
		}else {
			System.out.println("Le client trouvé est : " + client);
		}
		return client;
	}

}
