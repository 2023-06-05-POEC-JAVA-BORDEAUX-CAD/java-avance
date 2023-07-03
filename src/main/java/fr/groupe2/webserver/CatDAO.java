/**
 * 
 */
package fr.groupe2.webserver;

import java.util.HashMap;
import java.util.Map;

import jakarta.ejb.Singleton;
import jakarta.ejb.Stateless;


/**
 * 
 */
@Singleton
public class CatDAO {
	 private Map<Integer, Cat> catMap;
	
	 private Map<Integer, Cat> cats = new HashMap<>();

	    
	    public CatDAO() {

	        this.cats.put(1, new Cat(1, "Tom"));

	        this.cats.put(2, new Cat(2, "Isodor"));

	        this.cats.put(3, new Cat(3, "Sylvestre"));

	        this.cats.put(4, new Cat(4, "Duchesse"));

	    }

	    

	    public Cat getCat(Integer id){

	        return cats.get(id);

	    }
	 
	 
	 	/* public void CatDao() {
	        // Initialisation de la map avec des couples (id, Pojo)
	        catMap = new HashMap<>();
	        catMap.put(1, new Cat(1, "Tom"));
	        catMap.put(2, new Cat(2, "Isodor"));
	        catMap.put(3, new Cat(3, "Sylvestre"));
	        catMap.put(4, new Cat(4, "Duchesse"));
	       
	    }

	    public Cat getCat(Integer id) {
	        return catMap.get(id);
	    }*/
	    

}
