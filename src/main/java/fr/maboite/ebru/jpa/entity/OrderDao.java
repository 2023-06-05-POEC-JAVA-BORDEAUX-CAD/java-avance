package fr.maboite.ebru.jpa.entity;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

//* Data Access Object: classe permettant 
//* d'accéder en lecture ou écriture au référentiel 
//* de données des Pojos (ici, une simple Map)

@Stateless
public class OrderDao {

	@PersistenceContext // on inject objet entitymanager
	protected EntityManager entityManager;

	public OrderJPA save(OrderJPA orderJpa) { // charge cet entité en BDD
		return this.entityManager.merge(orderJpa);
	}

	public OrderJPA load(Integer id) {

		return this.entityManager.find(OrderJPA.class, id);
	}

	//equivalent requete sql: sleect*from orders where designation=...
	
	// renvoie tous les Orders qui ont comme designation designation
	
	public List<OrderJPA> findByDesignation(String argumentDeMethodedesignation) {
		
		Query jpqlQuery= this.entityManager.createQuery("select o "
				+" from Orders o " 
				+ " where o.designation = :parametreDeRequetedesignation", OrderJPA.class);
		jpqlQuery.setParameter("parametreDeRequetedesignation", argumentDeMethodedesignation);
		
		
		// o.designation = o.getdesignation, o est un alias, designation= attribut
		// setParameter, comme dans map a une clé (String) et une valeur objet(argument)
		
		return jpqlQuery.getResultList();
	}
	
}
