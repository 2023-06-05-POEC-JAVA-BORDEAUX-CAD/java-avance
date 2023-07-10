package fr.maboite.ebru.jpa.entity;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//* Data Access Object: classe permettant 
//* d'accéder en lecture ou écriture au référentiel 
//* de données des Pojos (ici, une simple Map)

@Stateless
public class OrderDao {

	@PersistenceContext // on inject objet entitymanager
	protected EntityManager entityManager;

	public void save(OrderJPA orderJpa) { // charge cet entité en BDD
		this.entityManager.merge(orderJpa);
	}

}
