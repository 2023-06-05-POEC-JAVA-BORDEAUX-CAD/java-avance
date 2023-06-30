package tp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoToJson {
    public static String toJson(Pojo pojo) throws JsonProcessingException {
        try {
            return new ObjectMapper().writeValueAsString(pojo);
        } catch (Exception e) {
            return "null";
        }
    }
}
