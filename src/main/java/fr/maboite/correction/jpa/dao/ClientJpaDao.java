package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.model.Client;
import fr.maboite.correction.jpa.model.Order;
import fr.maboite.correction.jpa.model.PojoJpa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Data Access Object: classe permettant d'accéder en lecture ou écriture au
 * référentiel de données des Pojos : ici, on se base sur JPA.
 */
@Stateless
public class ClientJpaDao {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Ceci est une Javadoc de méthode
	 * 
	 * @param client
	 * @return
	 */
	public Client save(Client client) {
		return this.entityManager.merge(client);
	}

	/**
	 * Récupère un client par id
	 * 
	 * @param id
	 * @return
	 */
	public Client load(Long id) {
		return this.entityManager.find(Client.class, id);
	}

	/**
	 * Supprime client par son id. Ne fait rien si id == null ou si aucun client n'a
	 * l'id en base de données.
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		if (id == null) {
			return;
		}

		Client savedEntity = this.entityManager.find(Client.class, id);
		if (savedEntity == null) {
			return;
		}
		this.entityManager.remove(savedEntity);
	}

	/**
	 * Renvoie tous les Client à partir de leur companyName
	 * 
	 * @param companyName
	 * @return
	 */
	public List<Client> findByCompanyName(String companyName) {
		TypedQuery<Client> jpqlQuery = this.entityManager.createQuery(
				"select c "
						+ " from Client c "
						+ " where c.companyName = :companyName ",
				Client.class);
		jpqlQuery.setParameter("companyName", companyName);
		return jpqlQuery.getResultList();
	}

	/**
	 * Renvoie tous les Client à partir de leur id
	 * 
	 * @param id
	 * @return
	 */
	public Client findById(Long id) {
		TypedQuery<Client> jpqlQuery = this.entityManager.createQuery(
				"select c "
						+ " from Client c "
						+ " where c.id = :id ",
				Client.class);
		jpqlQuery.setParameter("id", id);
		return jpqlQuery.getSingleResult();
	}

}