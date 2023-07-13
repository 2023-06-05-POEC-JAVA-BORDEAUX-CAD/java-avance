package fr.maboite.correction.jpa.service;

import fr.maboite.correction.jpa.dao.ClientJpaDao;
import fr.maboite.correction.jpa.model.Client;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {
	
	@Inject
	private ClientJpaDao clientJpaDao;
	
	/**
	 * Sauvegarde client, mais ne le modifie pas. Renvoie une instance
	 * qui correspond au client en base de données.
	 * @param client
	 * @return
	 */
	public Client save(Client client) {
		System.out.println("Sauvegarde de : " + client);
		return this.clientJpaDao.save(client);
	}
	
	/**
	 * Récupère un client par id
	 * @param id
	 * @return
	 */
	public Client getById(Long id) {
		System.out.println("Chargement de client avec id : " + id);
		Client client = this.clientJpaDao.load(id);
		if(client == null) {
			System.out.println("Aucun client trouvé");
		}else {
			System.out.println("Le client trouvé est : " + client);
		}
		return client;
	}
	
	/**
	 * Supprime client. Ne fait rien
	 * si client == null ou si aucune ligne
	 * ayant la même clé primaire n'existe en base de données.
	 * @param client
	 */
	public void delete(Client client) {
		if(client == null) {
			return;
		}
		this.clientJpaDao.delete(client.getId());
	}

}
