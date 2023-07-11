package fr.maboite.correction.jpa.dao;

import fr.maboite.correction.jpa.model.PojoJpa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Data Access Object: classe permettant d'accéder en lecture ou écriture au
 * référentiel de données des Pojos (ici, une simple Map)
 */
@Stateless
public class PojoJpaDao {

	
	@PersistenceContext // on inject objet entitymanager
	protected EntityManager entityManager;

//	public void test() {
//		System.out.println(entityManager);
//	}
	
	public PojoJpa save(PojoJpa pojoJpa) {  // charge cet entité en BDD
		return this.entityManager.merge(pojoJpa);
	}
	
	
	
}