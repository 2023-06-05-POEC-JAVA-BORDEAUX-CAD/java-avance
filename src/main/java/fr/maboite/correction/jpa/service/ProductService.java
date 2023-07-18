package fr.maboite.correction.jpa.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.ProductJpaDao;
import fr.maboite.correction.jpa.model.Product;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ProductService {
	
	@Inject
	private ProductJpaDao productJpaDao;
	
	/**
	 * Sauvegarde product, mais ne le modifie pas. Renvoie une instance
	 * qui correspond au product en base de données.
	 * @param product
	 * @return
	 */
	public Product save(Product product) {
		System.out.println("Sauvegarde de : " + product);
		return this.productJpaDao.save(product);
	}
	
	/**
	 * Récupère un product par id
	 * @param id
	 * @return
	 */
	public Product load(Long id) {
		System.out.println("Chargement de product avec id : " + id);
		Product product = this.productJpaDao.load(id);
		if(product == null) {
			System.out.println("Aucun product trouvé");
		}else {
			System.out.println("Le product trouvé est : " + product);
		}
		return product;
	}
	
	/**
	 * Supprime product par son id. Ne fait rien
	 * si id == null ou si aucune ligne
	 * ayant la même clé primaire n'existe en base de données.
	 * @param product
	 */
	public void delete(Long id) {
		if(id == null) {
			return;
		}
		this.productJpaDao.delete(id);
	}

	/**
	 * Renvoie tous les products à partir de leur name
	 * @param name
	 * @return
	 */
	public List<Product> findByName(String name) {
		return this.productJpaDao.findByName(name);
	}

}
