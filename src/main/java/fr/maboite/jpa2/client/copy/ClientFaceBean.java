package fr.maboite.jpa2.client.copy;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {

	@Inject
	private ClientService clientService;

	public void save() {
		Client client = new Client();
		client.setCompanyName("Jobi joba");
		client.setFirstName("Laurent");
		client.setLastName("Joufard");
		client.setEmail("ljoufard@gmail.com");
		client.setPhone("0245785684");
		client.setAddress("10 rue des lilas");
		client.setZipCode("48000");
		client.setCity("Bourgoin");
		client.setCountry("France");
		client.setState(1);

		clientService.save(client);

	}

	public void load() {
		clientService.load(1);

	}
}
