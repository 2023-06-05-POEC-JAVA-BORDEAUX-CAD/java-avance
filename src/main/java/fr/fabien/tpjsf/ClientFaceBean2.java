package fr.fabien.tpjsf;

import fr.fabien.tpjsf.jpamodel.ClientModel;
import fr.fabien.tpjsf.jpamodel.OrderModel;
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
		OrderModel order = new OrderModel();
		//order.setClientId(1);
		order.setTypePresta("Formation Test");
		order.setDesignation("JavaScript");
		orderService.save(order);

		System.out.println("" + order.getDesignation());
	}

		public void sauvegardeClient() {
			ClientModel client = new ClientModel();
			client.setId(null);
			client.setCompanyName("OpenAI");
			client.setFirstName("Bob");
			client.setEmail("Bob@open.ai");
			client.setPhone("0123456789");
			client.setAdress("12 rue du code");
			client.setZipCode("32400");
			client.setCity("San Francisco");
			client.setCountry("USA");
			client.setState(ClientModel.State.CONFIRMED);
			
			
			clientService.save(client);

			//System.out.println("" + loadedClient.getDesignation());	
		
		
	}

}