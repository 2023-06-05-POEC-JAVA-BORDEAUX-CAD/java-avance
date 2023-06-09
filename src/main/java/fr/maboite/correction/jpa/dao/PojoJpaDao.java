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

	@PersistenceContext
	protected EntityManager entityManager;

	public PojoJpa save(PojoJpa pojoJpa) {
		return this.entityManager.merge(pojoJpa);
	}

}