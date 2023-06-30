package tp;

import java.util.ArrayList;
import java.util.List;

public class PojoDao {
    private List<Pojo> pojoList;

    public PojoDao() {
        this.pojoList = new ArrayList<Pojo>();

        this.pojoList.add(new Pojo("Alexis")); // 0
        this.pojoList.add(new Pojo("Fabien")); // 1
        this.pojoList.add(new Pojo("Farid")); // 2
    }

    public Pojo getPojo(Integer id) {
        if (id < 0 || id >= this.pojoList.size()) {
            return null;
        }
        return this.pojoList.get(id);
    }
}
