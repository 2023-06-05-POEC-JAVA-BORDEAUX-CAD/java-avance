package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.model.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
	 * Supprime client par son id. Ne fait rien si id == null ou si aucun client n'a
	 * l'id en base de données. Utilise JPQL pour ce faire
	 * 
	 * @param id
	 */
	public void deleteJpql(Long id) {
		if (id == null) {
			return;
		}
		Query query = this.entityManager.createQuery(
				"delete Client c where c.id = :id ");
		query.setParameter("id", id);
		query.executeUpdate();
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
	

	/**
	 * Renvoie tous les Client ayant firstName et lastName
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Client> findByFirstNameAndLastName(String firstName, String lastName) {
		TypedQuery<Client> jpqlQuery = this.entityManager.createQuery(
				"select c "
						+ " from Client c "
						+ " where c.firstName = :firstName "
						+ " and c.lastName = :lastName ",
				Client.class);
		jpqlQuery.setParameter("firstName", firstName);
		jpqlQuery.setParameter("lastName", lastName);
		return jpqlQuery.getResultList();
	}

	/**
	 * Renvoie tous les clients à partir de leur id,
	 * avec les orders associés
	 * 
	 * @param id
	 * @return
	 */
	public List<Client> findByIdWithOrders(Long id) {
		TypedQuery<Client> jpqlQuery = this.entityManager.createQuery(
				"select c "
				+ " from Client c "
				+ " left outer join fetch c.orders o "
				+ " where c.id = :id ",
				Client.class);
		// on a utilisé fetch ici car on a choisi de garder FetchType.Lazy pour ne pas comliquer la tache..
		
		jpqlQuery.setParameter("id",id );
		return jpqlQuery.getResultList();
	}

}