package fr.noellie.jpa.dao;

import java.util.List;

import fr.noellie.jpa.model.ClientJPA;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class ClientJPADao {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Sauvegarde un client
	 * 
	 * @param clientJPA
	 * @return
	 */
	public ClientJPA save(ClientJPA clientJPA) {
		return this.entityManager.merge(clientJPA);
	}

	/**
	 * Récupère un client par ID
	 * 
	 * @param id
	 * @return
	 */
	public ClientJPA load(Long id) {
		return this.entityManager.find(ClientJPA.class, id);
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

		ClientJPA savedEntity = this.entityManager.find(ClientJPA.class, id);
		if (savedEntity == null) {
			return;
		}
		this.entityManager.remove(savedEntity);
	}

	/**
	 * Renvoie tous les clients dont le companyName vaut company_name
	 * 
	 * @param companyName
	 * @return
	 */
	public List<ClientJPA> findByCompanyName(String companyName) {
		TypedQuery<ClientJPA> createQuery = this.entityManager.createQuery(
				"select c " + "from ClientJPA c " + "where c.companyName = :company_name", ClientJPA.class);
		createQuery.setParameter("company_name", companyName);
		return createQuery.getResultList();
	}

}