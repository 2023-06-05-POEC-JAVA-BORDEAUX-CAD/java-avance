package fr.fabien.tpjsf;

import fr.fabien.tpjsf.jpamodel.Client;
import fr.fabien.tpjsf.jpamodel.Order;
import fr.fabien.tpjsf.jpaservice.ClientService;
import fr.fabien.tpjsf.jpaservice.OrderService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean2 {


	@Inject
	private ClientService clientService;
	
	@Inject 
	private OrderService orderService;



	public void sauvegardeOrder() {
		Order order = new Order();
		//order.setClientId(1);
		order.setType_presta("Formation Test");
		order.setDesignation("JavaScript");
		orderService.save(order);

		System.out.println("" + order.getDesignation());
	}

		public void sauvegardeClient() {
			Client client = new Client();
			client.setId(null);
			client.setCompany_Name("OpenAI");
			client.setFirst_Name("Bob");
			client.setEmail("Bob@open.ai");
			client.setPhone(04);
			client.setAdress("12 rue du code");
			client.setZipCode(32400);
			client.setCity("San Francisco");
			client.setCountry("USA");
			client.setState(null);
			
			
			clientService.save(client);

			//System.out.println("" + loadedClient.getDesignation());	
		
		
	}

}