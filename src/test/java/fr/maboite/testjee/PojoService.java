package fr.maboite.testjee;

public class PojoService {

	private PojoDao pojoDao;

    public PojoService(PojoDao pojoDao) {
        this.pojoDao = pojoDao;
    }

    public Pojo getPojo(int id) {
        return pojoDao.get(id);
    }
}
