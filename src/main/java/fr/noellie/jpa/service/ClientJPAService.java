package fr.noellie.jpa.service;

import fr.noellie.jpa.dao.ClientJPADao;
import fr.noellie.jpa.model.ClientJPA;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientJPAService {
	@Inject
	private ClientJPADao clientJPADao;
	
	/**
	 * Sauvegarde client, mais ne le modifie pas. Renvoie une instance
	 * qui correspond au Client en base de données.
	 * @param client
	 * @return
	 */
	public ClientJPA save(ClientJPA orderJPA) {
		System.out.println("Sauvegarde de : " + orderJPA);
		return this.clientJPADao.save(orderJPA);
	}
	
	/**
	 * Récupère un clientJPA par id
	 * @param id
	 * @return
	 */
	public ClientJPA load(Long id) {
		System.out.println("Chargement de clientJPA avec id : " + id);
		ClientJPA clientJPA = this.clientJPADao.load(id);
		if(clientJPA == null) {
			System.out.println("Aucun clientJPA trouvé");
		}else {
			System.out.println("Le clientJPA trouvé est : " + clientJPA);
		}
		return clientJPA;
	}
}