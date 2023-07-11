package fr.boite.philippe.jsf.controller;

import fr.boite.philippe.ClientJpa;
import fr.boite.philippe.ClientJpaDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientJpaFaceBean {

	@Inject
	private ClientJpaDao clientJpaDao;

	@Inject
	private ClientJpaService clientJpaService;

	public void saveClientJpa() {
		ClientJpa clientJpa = new ClientJpa();
		clientJpa.setCompanyName("Formation M2i");
		clientJpa.setFirstName("philippe");
		clientJpa.setLastName("HASSAN");
		clientJpa.setEmail("hassan.philippe@yahoo.com");
		clientJpa.setPhone("0506070809");
		clientJpa.setAddress("boulevard de la paix");
		clientJpa.setZipCode("64000");
		clientJpa.setCity("Pau");
		clientJpa.setCountry("France");
		clientJpa.setState(1);
		clientJpaDao.save(clientJpa);
		ClientJpa savedClientJpa = clientJpaService.save(clientJpa);
		
		ClientJpa loadedClientJpa = clientJpaService.load(savedClientJpa.getId());
		System.out.println("le mail de client : " 
			+ loadedClientJpa.getEmail() + " pour l'id : " 
			+ loadedClientJpa.getId());
	}
}
