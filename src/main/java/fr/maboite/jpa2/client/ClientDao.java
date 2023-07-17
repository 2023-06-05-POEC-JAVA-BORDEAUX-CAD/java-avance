package fr.maboite.jpa2.client;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientDao {

	@PersistenceContext
	protected EntityManager entityManager;

	// On crée un nouveau client dans la BDD dédidée, en lui envoyant un client (via
	// ClientService)
	public Client save(Client client) {
		return this.entityManager.merge(client);

	}

	// On cherche un client dans le BDD dédiée grâce à son ID
	public Client load(Integer id) {
		if (id == null) {
			return this.entityManager.find(Client.class, 1);

		} else {
			return this.entityManager.find(Client.class, id);

		}
	}

	/**
	 * Renvoie tous les CLients dont la désignation vaut "nom"
	 * 
	 * @param nom
	 * @return
	 */
	public List<Client> findByName(String companyName) {
		jakarta.persistence.Query jpqlQuery = this.entityManager
				.createQuery("select c " + "from Client c " + "where c.companyName = :nom", Client.class);

		jpqlQuery.setParameter("nom", companyName);
		List<Client> listClient = jpqlQuery.getResultList();
		for (Client client : listClient) {
			System.out.println("Client : " + client.getCompanyName());
		}

		return listClient;

	}

	public List<Client> findByNameAndCity(String companyName, String city) {
		jakarta.persistence.Query jpqlQuery = this.entityManager.createQuery(
				"select c " + "from Client c " + "where c.companyName = :nom and c.city= :ville", Client.class);

		jpqlQuery.setParameter("nom", companyName);
		jpqlQuery.setParameter("ville", city);
		List<Client> listClient = jpqlQuery.getResultList();
		for (Client client : listClient) {
			System.out.println("Client : " + client.getCompanyName() + " à " + client.getCity());
		}

		return listClient;

	}

}
