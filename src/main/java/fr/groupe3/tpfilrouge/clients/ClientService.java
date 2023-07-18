package fr.groupe3.tpfilrouge.clients;


import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {
	
	@Inject
	private ClientDao clientDao;
	
	
	public Client save(Client client) {
		System.out.println("Sauvegarde de : " + client);
		return this.clientDao.save(client);
	}
	
	
	 
	public Client load(Long id) {
		System.out.println("Chargement de order avec id : " + id);
		Client client = this.clientDao.load(id);
		if(client == null) {
			System.out.println("Aucun order trouvé");
		}else {
			System.out.println("L'order trouvé est : " + client);
		}
		return client;
	}

}
