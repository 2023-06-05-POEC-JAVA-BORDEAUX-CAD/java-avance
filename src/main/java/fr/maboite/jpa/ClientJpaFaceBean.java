package fr.maboite.jpa;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientJpaFaceBean {

	@Inject
	private ClientJpaService clientJpaService;

	@Inject
	private ClientJpaDao clientJpaDao;
	
	
	private ClientJpa clientJpa;
	
	private int loadId;

	public String saveCli() {
		ClientJpa clientJpa = new ClientJpa();
		clientJpa.setCompanyName("Capgemini");
		clientJpa.setFirstName("Pierro");
		clientJpa.setLastName("Lefou");

		clientJpaService.saveClient(clientJpa);

		return "succes";

	}
	public void  onLoad() {
		System.out.println("je suis en charge");
		if (loadId != 0) {
			ClientJpa clientJpa=clientJpaService.findClient(loadId);
			System.out.println("le client est : " + clientJpa.getCompanyName());
					
		}
		else {
			return ;
		}	
		
		
	}
	
	public ClientJpa afficherClient() {
		ClientJpa clientJpa=clientJpaService.findClient(loadId);
		return clientJpa;
	}
	


	public int getLoadId() {
		return loadId;
	}

	public void setLoadId(int loadId) {
		this.loadId = loadId;
	}

	

}
