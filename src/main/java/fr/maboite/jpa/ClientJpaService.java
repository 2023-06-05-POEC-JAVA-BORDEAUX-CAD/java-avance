package fr.maboite.jpa;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientJpaService {

	@Inject
	private ClientJpaDao clientJpaDao;

	/**
	 * Sauvegarde Client, mais ne le modifie pas.Renvoie une instance qui correspond
	 * à Clientjpa en base de données.
	 * 
	 * @param Clientjpa
	 * @return
	 */
	public ClientJpa saveClient(ClientJpa clientjpa) {
		System.out.println("Sauvegarde de : " + clientjpa);
		return this.clientJpaDao.saveClient(clientjpa);

	}

	/**
	 * Charge (récupere) un Client en fonction de l'id
	 * 
	 * @param id
	 * @return
	 */
	public ClientJpa findClient(Integer id) {
		System.out.println("Chargement de Client avecc id : " + id);
		ClientJpa clientjpa = this.clientJpaDao.findClient(id);
		if (clientjpa == null) {
			System.out.println("élement non trouvé");
		} else {
			System.out.println("élement trouvé");
		}
		return clientjpa;
	}

}
