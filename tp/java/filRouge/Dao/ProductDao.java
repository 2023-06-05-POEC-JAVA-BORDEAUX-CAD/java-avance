package filRouge.Dao;

import java.util.List;

import filRouge.model.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
@Stateless
public class ProductDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Product save(Product product) {
		System.out.println("TRIGGER save");
	return 	this.entityManager.merge(product);
		
	}
	
	
	public Product find(int id) {
		System.out.println(this.entityManager.find(Product.class, id));
		return this.entityManager.find(Product.class, id);
	}
	

	public void delete(int id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

	public List<Product> findAll(){
		 TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
		 List<Product> allProducts  = query.getResultList();
		return allProducts;
	}
}
