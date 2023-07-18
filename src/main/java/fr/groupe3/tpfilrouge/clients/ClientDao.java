package fr.groupe3.tpfilrouge.clients;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jakarta.ejb.Stateless;
import jakarta.persistence.EnumType;

@Stateless
public class ClientDao {

	// ensemble d'objet come une List
	private Map<Long, Client> clients = new HashMap<>();

	public ClientDao() {

		Client Fabrice = new Client();
		Fabrice.setId((long)1); // on initialise
		Fabrice.setCompanyName("Capgemini");
		Fabrice.setFirstName("Fabrice");
		Fabrice.setLastName("Martin");
		Fabrice.setEmail("martin@mail.com");
		Fabrice.setPhone("06 56 85 84 33");
		Fabrice.setAdress("abc");
		Fabrice.setZipCode("xyz");
		Fabrice.setCity("Nantes");
		Fabrice.setCountry("France");
		Fabrice.setState(EtatClient.ACTIVE);

		// Fabrice qu'on vient de creer on l ajoute à notre Map clients
		this.clients.put(Fabrice.getId(), Fabrice);

		Client Julien = new Client();
		Julien.setId((long)2); // on initialise
		Julien.setCompanyName("M2i Formation");
		Julien.setFirstName("Julien");
		Julien.setLastName("Lamard");
		Julien.setEmail("lamard@mail.com");
		Julien.setPhone("06 11 22 33 44");
		Julien.setAdress("abc");
		Julien.setZipCode("xyz");
		Julien.setCity("Paris");
		Julien.setCountry("France");
		Julien.setState(EtatClient.INACTIVE);

		this.clients.put(Julien.getId(), Julien);

	}

	public Client getClient(Long id) {
		return this.clients.get(id);
	}

	public Map<Long, Client> getAllClient() {

		return clients;

	}

}
