package fr.groupe3.tpfilrouge.clients;

import java.util.HashMap;
import java.util.Map;

public class ClientDao {

	private Map<Integer, Client> clients = new HashMap<>();

	public ClientDao() {

		Client Fabrice = new Client();
		Fabrice.setId(1); // on initialise
		Fabrice.setCompanyName("Capgemini");
		Fabrice.setFirstName("Fabrice");
		Fabrice.setLastName("Martin");
		Fabrice.setEmail("martin@mail.com");
		Fabrice.setPhone("06 56 85 84 33");
		Fabrice.setAdress("abc");
		Fabrice.setZipCode("xyz");
		Fabrice.setCity("Nantes");
		Fabrice.setCountry("France");
		Fabrice.setState(0);

		this.clients.put(Fabrice.getId(), Fabrice);

		Client Julien = new Client();
		Julien.setId(2); // on initialise
		Julien.setCompanyName("M2i Formation");
		Julien.setFirstName("Julien");
		Julien.setLastName("Lamard");
		Julien.setEmail("lamard@mail.com");
		Julien.setPhone("06 11 22 33 44");
		Julien.setAdress("abc");
		Julien.setZipCode("xyz");
		Julien.setCity("Paris");
		Julien.setCountry("France");
		Julien.setState(1);

		this.clients.put(Julien.getId(), Julien);

	}

	public Client getClient(Integer id) {
		return this.clients.get(id);
	}

}
