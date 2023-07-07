package Clientjsf;

import jakarta.inject.Named;

@Named
public class ClientService {
	
	public void save(ClientFaceBean clientfacebean) {
		//Sauvegarde de client
		System.out.println("Sauvegarde de :" +clientfacebean);
		
	}
	
	
	public void load() {
		 // Logique de chargement du client
        ClientFaceBean client = new ClientFaceBean();
        
        System.out.println("Chargement du client : " + client);
        
	}
	

}
