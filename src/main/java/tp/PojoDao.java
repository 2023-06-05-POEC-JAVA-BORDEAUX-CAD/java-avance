package tp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Map<String, String> langues = new HashMap<>();
//https://docs.oracle.com/javase/8/docs/api/java/util/Map.html

public class PojoDao {
	// private List<Pojo> pojoList;
    private Map<Integer, Pojo> pojoList;
    
    public PojoDao() {
    	// this.pojoList = new ArrayList<Pojo>();   
        this.pojoList = new HashMap<>(); // ou new HashMap<Integer, Pojo>();

        //  this.pojoList.add( new Pojo("Alexis")); // liste commence par l'index 0
        this.pojoList.put(1, new Pojo("Alexis")); // hashMap nous définissons nous-même la Key (key , value)
        this.pojoList.put(3, new Pojo("Fabien"));
        this.pojoList.put(2, new Pojo("Farid")); 
        this.pojoList.put(9, new Pojo("Marie"));
    }

    public Pojo getPojo(Integer id) {
        /*if (id < 0 || id >= this.pojoList.size()) {
            return null;
        }
        return this.pojoList.get(id);*/
    	if (this.pojoList.containsKey(id)) {
    		return this.pojoList.get(id);
    	} 
    	return null;  // retourne null et la class Home affichera l'erreur correspondante
    }
}
