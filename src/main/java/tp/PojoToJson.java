package tp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// récupère une instance de Pojo en param
// retourne soit l'instance de Pojo au format JSON : {"name": "name here"} 
// ou retourne null au format JSON : "null"

public class PojoToJson {
    public static String toJson(Pojo pojo) { 
        try {
            return new ObjectMapper().writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            return "null";
        }
    }
}
