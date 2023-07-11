package Florian;

import Florian.TP_entity.ClientEntity;
import Florian.TP_entity.OrderEntity;
import Florian.TP_entity.OrderEnum;
import Florian.TP_entity.OrderService;
import Florian.TP_entity.ClientEntityService;
import Florian.TP_entity.ClientEnum;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {

	@Inject
	private ClientService clientService;

	@Inject
	private OrderService orderService;
	
	@Inject
	private ClientEntityService clientEntityService;

	// Attribut
	private Integer loadId;
	private ClientFormBean client = new ClientFormBean();

	// Getters
	public ClientFormBean getClient() {
		return client;
	}

	public Integer getLoadId() {
		return loadId;
	}

	// Setters
	public void setClient(ClientFormBean client) {
		this.client = client;
	}

	public void setLoadId(Integer loadId) {
		this.loadId = loadId;
	}

	// Le message sur la vue-client
	private String message = "Veuillez renseigner vos informations et cliquer sur sauvegarder";

	public String getMessage() {
		return message;
	}

	// Affiche la vue client depuis premiere-page
	public String createNew() {
		return "vue-client";
	}

	public void onLoad() {
		System.out.println("j'affiche le client avec l'id :" + loadId);
		this.client = clientService.load(loadId);
	}

	public String save() {
		System.out.println("j'affiche le client avec l'id :" + loadId);
		this.clientService.save(client);
		return null;
	}

	public void sauvegardeOrder() {
		OrderEntity order = new OrderEntity();
		order.setTypePresta(OrderEnum.FORMATION);
		//order.setTypePresta("Formation");
		order.setDesignation("test");
		order.setClientId(1);
		OrderEntity savedOrder = orderService.save(order);
		
		OrderEntity loadedOrder = orderService.load(savedOrder.getId());
		System.out.println("En base, j'ai un order dont la désignation vaut : " 
				+ loadedOrder.getDesignation() + " pour l'id : " + loadedOrder.getId());
	}
	
	public void sauvegardeClient() {
		ClientEntity client = new ClientEntity();
		client.setCompanyName(ClientEnum.M2iFORMATION);
		//client.setCompanyName("M2i Formation");
		client.setFirstName("Francois");
		client.setLastName("Caremoli");
		client.setEmail("FrancoisCaremoli@gmail.com");
		client.setPhone("06 00 00 00 00 ");
		client.setAdress("CaremoliPlaza");
		client.setZipCode("99999");
		client.setCity("CaremoliCity");
		client.setCountry("L'empire Caremoli");
		client.setState(1);
		ClientEntity savedClient = clientEntityService.save(client);
		
		ClientEntity loadedClient = clientEntityService.load(savedClient.getId());
		System.out.println("En base, j'ai un Client dont le company name vaut : " 
				+ loadedClient.getCompanyName() + " pour l'id : " + loadedClient.getId());
	}
}
