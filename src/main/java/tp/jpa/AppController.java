package tp.jpa;

import jakarta.inject.Named;
import jakarta.inject.Inject;
import tp.jpa.ClientModel.State;
import jakarta.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class AppController {
	@Inject
	private ClientService cliService;

	@Inject
	private OrderService ordService;

	public String saveClient() {
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
		client.setState(State.CONFIRMED);
		cliService.save(client);
		return "end";
	}

	public String saveOrder() {
		OrderModel order = new OrderModel();
		order.setTypePresta("Test");
		order.setDesignation("Petit test");
		order.setClientId(1); // not nullable
		ordService.save(order);
		return "end";
	}

}