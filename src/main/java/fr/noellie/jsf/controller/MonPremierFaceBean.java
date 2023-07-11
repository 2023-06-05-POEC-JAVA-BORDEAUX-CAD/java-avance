package fr.noellie.jsf.controller;

import fr.noellie.jpa.dao.ClientJPADao;
import fr.noellie.jpa.dao.OrderJPADao;
import fr.noellie.jpa.model.ClientJPA;
import fr.noellie.jpa.model.OrderJPA;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MonPremierFaceBean {

	@Inject
	private OrderJPADao orderJPADao;
	
	@Inject
	private ClientJPADao clientJPADao;

	private String message = "Ce message vient du controller MonPremierFaceBean";

	public String getMessage() {
		return message;
	}

	public void sauvegardeOrderJPA() {
		OrderJPA orderJPA = new OrderJPA();
		orderJPA.setTypePresta("Coaching");
		orderJPA.setDesignation("Git & GitHub");
		orderJPA.setClientId(4);
		OrderJPA savedOrder = orderJPADao.save(orderJPA);
		
		OrderJPA loadedOrder = orderJPADao.load(savedOrder.getId());
		System.out.println("En base, j'ai un order dont l'id est " 
				+ loadedOrder.getId() + " et la désignation : "
				+ loadedOrder.getDesignation());
	}
	
	public void sauvegardeClientJPA() {
		ClientJPA clientJPA = new ClientJPA();
		clientJPA.setCompanyName("Mairie de Bayonne");
		clientJPA.setFirstName("Patrick");
		clientJPA.setLastName("Sébastien");
		clientJPA.setEmail("patrick.sebastien@mail.fr");
		clientJPA.setPhone("06 06 06 06 06");
		clientJPA.setAdress("123 Rue des Lilas");
		clientJPA.setZipCode("64100");
		clientJPA.setCity("Bayonne");
		clientJPA.setCountry("France");
		clientJPA.setState(1);
		ClientJPA savedClient = clientJPADao.save(clientJPA);
		
		ClientJPA loadedClient = clientJPADao.load(savedClient.getId());
		System.out.println("En base, j'ai un client dont l'entreprise est " 
				+ loadedClient.getCompanyName()
				+ " et dont le nom complet est "
				+ loadedClient.getFirstName() + " " + loadedClient.getLastName());
	}

}