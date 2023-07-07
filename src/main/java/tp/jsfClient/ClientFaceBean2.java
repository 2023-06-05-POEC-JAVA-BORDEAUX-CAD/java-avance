package tp.jsfClient;

import jakarta.inject.Named;
import jakarta.inject.Inject;
import tp.projetfilrouge.pojo.Client;
import jakarta.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class ClientFaceBean2 {
	private String loadId;
	private Client client = new Client();

	@Inject
	private ClientFBService beanClientService;

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientFBService getBeanClientService() {
		return beanClientService;
	}

	public void setBeanClientService(ClientFBService beanClientService) {
		this.beanClientService = beanClientService;
	}

	public String createNew() {
		System.out.println("create new is called");
		return "client";
	}

	public void onLoad() {
		this.client = this.beanClientService.load(this.loadId);
	}

	public String save() {
		this.beanClientService.save(this.client);
		return "vueclient";
	}
}
