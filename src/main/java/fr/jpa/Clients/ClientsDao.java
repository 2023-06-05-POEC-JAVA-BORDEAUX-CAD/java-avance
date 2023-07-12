package fr.jpa.Clients;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;



/**
 * Data Access Object: classe permettant d'accéder en lecture ou écriture au
 * référentiel de données des Pojos : ici, on se base sur JPA.
 */
@Stateless
public class ClientsDao {

  @PersistenceContext
  protected EntityManager entityManager;

  /**
	 * Sauvegarde order, mais ne le modifie pas. Renvoie une instance
	 * qui correspond à l'Order en base de données.
	 * @param clients
	 */
  public Clients save(Clients clients) {
  return this.entityManager.merge(clients);
 }


 /**
	 * Récupère un order par id
	 * @param id
	 * @return
	 */
  public Clients load(Integer id) {
  return this.entityManager.find(Clients.class, id);
}
  
/**
	 * Renvoie tous les Order dont la désignation vaut designation
	 * 
	 * @param argumentDeMethodeCompanyName
	 * @return
	 */
	public List<Clients> findByCompanyName(String argumentDeMethodeCompanyName) {
		TypedQuery<Clients> jpqlQuery = this.entityManager.createQuery(
				"select c "
				+ " from Clients c "
				+ " where c.companyName = :parametreDeRequeteCompanyName", Clients.class);
		jpqlQuery.setParameter("parametreDeRequeteCompanyName", argumentDeMethodeCompanyName);
		return jpqlQuery.getResultList();
	}


}
