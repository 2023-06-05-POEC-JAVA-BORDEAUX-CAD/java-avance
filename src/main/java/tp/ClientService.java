package tp;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;

public class ClientService {
	private Integer idsearch;

	public ClientService() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	ClientFormBean cfb = new ClientFormBean();

	public String search() {
		System.out.println("Nous avons bien reçu votre requête" + idsearch);
		return getClientFromList(idsearch);
	}

	public List<ClientFormBean> populate() {
		List<ClientFormBean> lcfb = new ArrayList<>();
		ClientFormBean a = new ClientFormBean(1, "Panama Airline");
		ClientFormBean b = new ClientFormBean(2, "Air France");
		ClientFormBean c = new ClientFormBean(3, "Iceland Air");
		ClientFormBean d = new ClientFormBean(4, "Aereo Italia");
		ClientFormBean e = new ClientFormBean(5, "Jeanjean Rail");
		lcfb.add(a);
		lcfb.add(b);
		lcfb.add(c);
		lcfb.add(d);
		lcfb.add(e);
		return lcfb;
	}

	public String getClientFromList(int id) {
		List<ClientFormBean> list = populate();
		if ((list.get(id) != null) || (id > list.size())) {
			return list.get(id).getCompanyName();
		} else
			return "Pas de compagnie à cette ID";

	}

}
