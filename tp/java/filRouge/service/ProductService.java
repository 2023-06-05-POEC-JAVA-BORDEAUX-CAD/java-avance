package filRouge.service;

import java.util.List;

import filRouge.Dao.ProductDao;
import filRouge.model.Product;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
@Stateless
public class ProductService {

	@Inject
	private ProductDao productDao;
	
	public Product save(Product product) {
		return productDao.save(product);
	}

	public Product load(int id) {
		return productDao.find(id);
	}
	
	public List<Product> findAll(){
		return productDao.findAll();
	}

	
	
	public void deleteById(int id) {
		Product ProductToDelete = productDao.find(id);
		System.out.println("suppression product: id " + ProductToDelete.getId() + " nom produit = " + ProductToDelete.getName()  );
		productDao.delete(id);
	}
	
}
