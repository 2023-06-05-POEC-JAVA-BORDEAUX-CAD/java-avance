package tp.jpa;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientController {
	@Inject
	private ClientDao cliDao;

	public void sauvegarde() {
		ClientModel client = new ClientModel();
		client.setCompanyName("COMP NAME");
		client.setFirstName("TestName");
		client.setLastName("LastName");
		client.setEmail("faketest@test.com");
		client.setPhone("0542134302");
		client.setAdress("Adresse de test");
		client.setZipCode("XYZ");
		client.setCity("VilleTest");
		client.setCountry("FRANCE");
		client.setState(0);
		cliDao.save(client);
	}
}