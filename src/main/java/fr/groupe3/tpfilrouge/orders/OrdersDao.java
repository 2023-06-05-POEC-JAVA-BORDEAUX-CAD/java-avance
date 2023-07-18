package fr.groupe3.tpfilrouge.orders;

import java.util.List;

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
public class OrdersDao {

  @PersistenceContext
  protected EntityManager entityManager;

  /**
	 * Sauvegarde order, mais ne le modifie pas. Renvoie une instance
	 * qui correspond à l'Order en base de données.
	 * @param orders
	 */
  public Orders save(Orders orders) {
  return this.entityManager.merge(orders);
 }


 /**
	 * Récupère un order par id
	 * @param id
	 * @return
	 */
  public Orders load(Integer id) {
  return this.entityManager.find(Orders.class, id);
}

/**
	 * Supprime order par son id. Ne fait rien si id == null ou si aucun order n'a
	 * l'id en base de données.
	 * 
	 * @param id
	 */
		
	public void deleteJpql(Integer id) {
		Query jpqlQuery = this.entityManager.createQuery(
				"delete "
				+ " from Order o "
				+ " where o.id = :id");
		jpqlQuery.setParameter("id", id);
		jpqlQuery.executeUpdate();
	}

	 public List<Orders> findAll() {
        TypedQuery<Orders> query = entityManager.createQuery("SELECT o FROM Orders o", Orders.class);
        return query.getResultList();
    }
  
}