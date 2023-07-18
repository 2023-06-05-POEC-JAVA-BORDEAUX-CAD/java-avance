package fr.groupe3.archives.tpfilrouge.clients;

import java.util.HashMap;
import java.util.Map;

import jakarta.ejb.Stateless;

@Stateless
public class ClientDaoArchive {

	// ensemble d'objet come une List
	private Map<Integer, ClientArchive> clients = new HashMap<>();

	public ClientDaoArchive() {

		ClientArchive Fabrice = new ClientArchive();
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

		// Fabrice qu'on vient de creer on l ajoute à notre Map clients
		this.clients.put(Fabrice.getId(), Fabrice);

		ClientArchive Julien = new ClientArchive();
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

	public ClientArchive getClient(Integer id) {
		return this.clients.get(id);
	}

	public Map<Integer, ClientArchive> getAllClient() {

		return clients;

	}

}