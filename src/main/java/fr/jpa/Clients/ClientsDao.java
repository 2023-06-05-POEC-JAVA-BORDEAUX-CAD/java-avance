package fr.jpa.Clients;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


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
  
}
