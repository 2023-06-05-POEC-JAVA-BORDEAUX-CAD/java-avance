package fr.maboite.correction.jpa.dao;

import java.awt.datatransfer.StringSelection;
import java.util.List;

import fr.maboite.correction.jpa.model.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class ProductJpaDao {

	private static final String EMPTY_STRING = "";
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Sauvegarde product et renvoie l'entité sauvegardée.
	 * 
	 * @param product
	 * @return
	 */
	public Product save(Product product) {
		return this.entityManager.merge(product);
	}

	/**
	 * Récupère un product par id
	 * 
	 * @param id
	 * @return
	 */
	public Product load(Long id) {
		return this.entityManager.find(Product.class, id);
	}

	/**
	 * Supprime product par son id. Ne fait rien si aucun product n'a l'id en base
	 * de données.
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		Query jpqlQuery = this.entityManager.createQuery(
				"delete "
						+ " from Product o "
						+ " where o.id = :id");
		jpqlQuery.setParameter("id", id);
		jpqlQuery.executeUpdate();
	}

	/**
	 * Récupère tous les produits par leur nom avec un like.
	 * 
	 * @param name
	 * @return
	 */
	public List<Product> findByName(String name) {
		//Si name == null, on le remplace par une chaîne vide
		//afin que l'on renvoie tous les products en base
		if(name == null) {
			name = EMPTY_STRING;
		}
		
		//On construit une requête JPQL en utilisant upper (comme en SQL)
		//et like avec % (comme en SQL) afin de faire une recherche de tous 
		//les produits dont le nom contient le paramètre name, sans tenir
		//compte de la casse
		return this.entityManager.createQuery(
				"select p "
						+ " from Product p "
						+ " where upper(p.name) like upper(:name)",
				Product.class)
				.setParameter("name", "%" + name + "%")
				.getResultList();
	}

}