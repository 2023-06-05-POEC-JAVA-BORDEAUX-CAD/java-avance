package fr.maboite.ebru.jpa.entity;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientJpaService {
	
	@Inject
	private ClientJpaDao clientDao;
	
	
	public ClientJPA save(ClientJPA clientJpa) {
		System.out.println("Sauvegarde de : " + clientJpa);
		return this.clientDao.save(clientJpa);
	}
	
	
	 
	public ClientJPA load(Integer id) {
		System.out.println("Chargement de order avec id : " + id);
		ClientJPA client = this.clientDao.load(id);
		if(client == null) {
			System.out.println("Aucun order trouvé");
		}else {
			System.out.println("L'order trouvé est : " + client);
		}
		return client;
	}

}
