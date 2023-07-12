package Florian.TP_entity;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClientEntityDao {
	
	
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Sauvegarde client, mais ne le modifie pas. Renvoie une instance qui correspond
	 * au client en base de données.
	 * 
	 * @param order
	 * @return
	 */
	public ClientEntity save(ClientEntity client) {
		return this.entityManager.merge(client);
	}

	/**
	 * Récupère un client par id
	 * 
	 * @param id
	 * @return
	 */
	public ClientEntity load(Integer id) {
		return this.entityManager.find(ClientEntity.class, id);
	}
	
	/**
	 * Renvoie tous les Clients dont companyName vaut companyName
	 * 
	 * @param argumentDeMethodedesignation
	 * @return
	 */
	public List<ClientEntity> findByCompanyName(String companyName) {
		Query jpqlQuery = this.entityManager.createQuery(
				"select c "
				+ " from ClientEntity c "
				+ " where c.companyName = : M2i Formation", ClientEntity.class);
		jpqlQuery.setParameter("M2i Formation", companyName);
		return jpqlQuery.getResultList();
	}
}
