package fr.maboite;
import com.google.inject.Inject;
import fr.groupe2.webserver.Cat;
import fr.groupe2.webserver.CatDaoInterface;
import jakarta.ejb.Stateless;

@Stateless
public class CatService {

	private static final String NOM_INTERDIT = "dangereux";

	@Inject
	private CatDaoInterface catDaoInterfaceImplementation;

	public void setCatDao(CatDaoInterface catDao) {
		this.catDaoInterfaceImplementation = catDao;
	}

	public void save(Cat cat) {
		// ... ne fait rien
	}

	public Cat get(Integer id) {
		
		Cat cat = catDaoInterfaceImplementation.getCat(id);
		if (cat == null) {
			return null;
		}
		if (cat.getName() != null
				&& cat.getName().equals(NOM_INTERDIT)) {
			//équivaut à	if(Objects.equals(cat.getName(), NOM_INTERDIT)) {
			throw new IllegalArgumentException("Un pojo dangereux a été chargé, ce qui est interdit");
		}
		return cat;
	}

}