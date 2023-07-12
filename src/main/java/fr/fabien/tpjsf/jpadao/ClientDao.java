package fr.fabien.tpjsf.jpadao;

import java.util.List;

import fr.fabien.tpjsf.jpamodel.Client;
import fr.fabien.tpjsf.jpamodel.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class ClientDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public Client find(Long id) {
		return this.entityManager.find(Client.class, id);
	}

	/**
	 * 
	 * @param order
	 * @return
	 */
	public Client save(Client client) { // charge cette entité en BDD
		return this.entityManager.merge(client);
	}

	/**
	 * 
	 * @param orderToDelete
	 */
	public void delete(Long orderToDelete) {
		if (orderToDelete == null) {
			return;
		}
		Client savedEntity = this.entityManager.find(Client.class, orderToDelete);
		if (savedEntity == null) {
			return;
		}
		this.entityManager.remove(savedEntity);
	}

	public List<Client> findByCompanyName(String companyName) {
		TypedQuery<Client> jpqlQuery = this.entityManager
				.createQuery(
						"select o " 
						+ " from Client o " 
						+ " where o.companyName = :companyName", Client.class);
		jpqlQuery.setParameter("companyName", companyName);
		return jpqlQuery.getResultList();
	}

}
