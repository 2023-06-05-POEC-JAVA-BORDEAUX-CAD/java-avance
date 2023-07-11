package fr.boite.philippe.jsf.controller;


import fr.boite.philippe.ClientJpa;
import fr.boite.philippe.ClientJpaDao;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientJpaService {
	@Inject
	private ClientJpaDao clientJpaDao;
	
	public ClientJpa save(ClientJpa clientJpa) {
		System.out.println("Sauvegarde de : " + clientJpa);
		return this.clientJpaDao.save(clientJpa);
	}
	
	public ClientJpa load(Integer id) {
		System.out.println("Chargement de clientJpa avec id : " + id);
		ClientJpa clientJpa = this.clientJpaDao.load(id);
		if(clientJpa == null) {
			System.out.println("Aucun clientJpa trouvé");
		} else {
			System.out.println("clientJpa trouvé est : " + clientJpa);
		}
		return clientJpa;
	}
}
