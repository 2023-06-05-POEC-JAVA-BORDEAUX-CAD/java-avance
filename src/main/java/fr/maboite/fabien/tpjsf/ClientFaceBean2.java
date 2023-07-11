package fr.maboite.fabien.tpjsf;

import java.time.LocalDateTime;

import fr.maboite.fabien.tpjsf.jpadao.ClientDao;
import fr.maboite.fabien.tpjsf.jpadao.OrderDao;
import fr.maboite.fabien.tpjsf.jpamodel.Client;
import fr.maboite.fabien.tpjsf.jpamodel.Order;
import fr.maboite.fabien.tpjsf.jpaservice.ClientService;
import fr.maboite.fabien.tpjsf.jpaservice.OrderService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean2 {

	@Inject
	private OrderDao orderDao;
	
	@Inject
	private ClientDao clientDao;

	@Inject
	private ClientService clientService;
	
	@Inject 
	private OrderService orderService;

	
	private String message = "Ce message vient du contrôleur";
	
	

	public String getMessage() {
		return LocalDateTime.now().toString();
	}

	public String getCoucou() {
		return "Salut ! ";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void sauvegardeOrder() {
		Order order = new Order();
		order.setClient_id(1);
		order.setType_presta("Formation Test");
		order.setDesignation("JavaScript");
		Order savedOrder= orderDao.save(order);

		Order loadedOrder = orderDao.find(savedOrder.getId());
		System.out.println("" + loadedOrder.getDesignation());
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
			
			
			Client savedClient= clientDao.save(client);

			Client loadedClient = clientDao.find(savedClient.getId());
			//System.out.println("" + loadedClient.getDesignation());	
		
		
	}

}