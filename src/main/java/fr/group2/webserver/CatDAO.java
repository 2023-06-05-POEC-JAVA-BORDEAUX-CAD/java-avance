package fr.group2.webserver;
import java.util.Map;
import java.util.HashMap;


public class CatDAO {
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
}
