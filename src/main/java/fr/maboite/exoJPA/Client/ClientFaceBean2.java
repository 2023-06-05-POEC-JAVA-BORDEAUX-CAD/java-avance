package fr.maboite.exoJPA.Client;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean2{
	
	@Inject
	private ClientJpaDao clientJpaDao;
	
	@Inject
	private ClientServiceJpa clientService;

	public void sauvegarder()
	{
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setCity("Tokyo");
		clientEntity.setCompanyName("Evil Company");
		clientEntity.setFirstName("Simon");
		clientEntity.setLastName("Moinet");
		clientEntity.setAdress("12 rue de l'Eclipse");
		clientEntity.setCountry("France");
		clientEntity.setEmail("Simon@gmail.com");
		clientEntity.setPhone("06 12 83 09 62");
		clientEntity.setZipCode("79 230");
		ClientEntity savedClient = clientService.save(clientEntity);
		
		ClientEntity loadedOrder = clientService.load(savedClient.getId());
		System.out.println("En base, j'ai un order dont la ville vaut : " 
				+ loadedOrder.getCity() + " pour l'id : " + loadedOrder.getId());
	}

}