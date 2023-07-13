package fr.maboite.correction.jsf.controller;

import java.time.LocalDateTime;
import java.util.List;

import fr.maboite.correction.jpa.dao.ClientJpaDao;
import fr.maboite.correction.jpa.dao.PojoJpaDao;
import fr.maboite.correction.jpa.model.Client;
import fr.maboite.correction.jpa.model.Order;
import fr.maboite.correction.jpa.model.PojoJpa;
import fr.maboite.correction.jpa.service.ClientService;
import fr.maboite.correction.jpa.service.OrderFrancoisService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MonPremierFaceBean {
	
	@Inject
	private PojoJpaDao pojoJpaDao;
	
	@Inject
	private ClientJpaDao clientJpaDao;
	
	@Inject
	private OrderFrancoisService orderFrancoisService;
	
	@Inject
	private ClientService clientService;

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
	
	public void sauvegardePojo() {
		PojoJpa pojoJpa = new PojoJpa();
		pojoJpa.setNom("Salut");
		pojoJpa.setAdresse(message);
		//pojoJpaDao.save(pojoJpa);
		
		List<Client> coucou = clientJpaDao.findByIdWithOrders(1l);
		for (Client client : coucou) {
			for(Order o : client.getOrders()) {
				System.out.println(o.getDesignation());
			}
		}
		
	}
	
	public void sauvegardeOrder() {
		Order order = new Order();
		order.setDesignation("commande Web");
		order.setTypePresta("Bien");
		Order savedOrder = orderFrancoisService.save(order);
		
		Order loadedOrder = orderFrancoisService.load(savedOrder.getId());
		System.out.println("En base, j'ai un order dont la désignation vaut : " 
				+ loadedOrder.getDesignation() + " pour l'id : " + loadedOrder.getId());
	}
	
	public void sauvegardeClient() {
		Client client = new Client();
		client.setAddress("6 avenue mismate");
		client.setCity("VilleFaquin");
		client.setCountry("Le pays où la vie est moins chère");
		client.setCompanyName("La compagnie créole");
		client.setEmail("james.bienjpa@lacompagniecreole.org");
		client.setFirstName("james");
		client.setLastName("bienjpa");
		client.setPhone("0102030405");
		client.setState(Boolean.FALSE);
		client.setZipCode("12345");
		Client savedClient = clientService.save(client);
		
		Client loadedClient = clientService.getById(savedClient.getId());
		System.out.println("En base, j'ai un client dont l'état vaut : " 
				+ loadedClient.getState() + " pour l'id : " + loadedClient.getId());
	}

}
