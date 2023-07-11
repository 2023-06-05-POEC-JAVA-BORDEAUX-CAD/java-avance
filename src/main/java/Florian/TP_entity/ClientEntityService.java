package Florian.TP_entity;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientEntityService {
	
	@Inject
	private ClientEntityDao clientEntityDao;

	/**
	 * Sauvegarde client, mais ne le modifie pas. Renvoie une instance qui correspond
	 * au client en base de données.
	 * 
	 * @param order
	 * @return
	 */
	public ClientEntity save(ClientEntity client) {
		System.out.println("Sauvegarde de : " + client);
		return this.clientEntityDao.save(client);
	}

	/**
	 * Récupère un client par id
	 * 
	 * @param id
	 * @return
	 */
	public ClientEntity load(Integer id) {
		System.out.println("Chargement de client avec id : " + id);
		ClientEntity client = this.clientEntityDao.load(id);
		if (client == null) {
			System.out.println("Aucun client trouvé");
		} else {
			System.out.println("Le client trouvé est : " + client);
		}
		return client;
	}
}
