package Florian;

import Florian.TP_entity.OrderEntity;
import Florian.TP_entity.OrdersEntityDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {

	@Inject
	private ClientService clientService;
	
	@Inject
	private OrdersEntityDao ordersEntityDao;

	private OrderEntity order;

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

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
	
	public String sauvegarde() {
		ordersEntityDao.save(order);
		return "Sauvegarde réussie";
	}
}
