package fr.jpa.Clients;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class ClientsService {

  @Inject
  ClientsDao clientsDao;

  /**
	 * Sauvegarde order, mais ne le modifie pas. Renvoie une instance
	 * qui correspond à l'Order en base de données.
	 * @param clients
	 * @return
	 */
	public Clients save(Clients clients) {
		System.out.println("Sauvegarde de : " + clients);
		return this.clientsDao.save(clients);
	}


  /**
	 * Récupère un order par id
	 * @param id
	 * @return
	 */
  public Clients load(Integer id) {
		System.out.println("Chargement de client avec id : " + id);
		Clients clients = this.clientsDao.load(id);
		if(clients == null) {
			System.out.println("Aucun client trouvé");
		}else {
			System.out.println("Le client trouvé est : " + clients);
		}
		return clients;
	}
}