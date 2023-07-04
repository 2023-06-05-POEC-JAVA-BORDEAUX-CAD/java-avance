package dev.loicmoreaux.pojoservlet;

import java.util.HashMap;
import java.util.Map;

import jakarta.ejb.Singleton;
//import jakarta.ejb.Stateless;

@Singleton
public class PojoDAO {
	
    private Map<Integer, Pojo> pojos = new HashMap<>();

    public PojoDAO() {
        this.pojos.put(1, new Pojo(1, "Tom"));
        this.pojos.put(2, new Pojo(2, "Isodor"));
        this.pojos.put(3, new Pojo(3, "Sylvestre"));
        this.pojos.put(4, new Pojo(4, "Duchesse"));
    }

    public Pojo getPojo(Integer id){

        return pojos.get(id);
    }
    
}