package fr.jpa.Clients;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientsFaceBean {
  
  @Inject
  private ClientsService clientsService;

  public void sauvegarde(){
    Clients clients = new Clients();    
    clients.setCompanyName("M2i Formation");
    //clients.setCompanyName(ClientsEnum.M2I_FORMATION);
    clients.setFirstName("Francois");
    clients.setLastName("Caremoli");
    clients.setEmail("FrancoisCaremoli@gmail.com");
    clients.setPhone("06 00 00 00 00 ");
    clients.setAddress("CaremoliPlaza");
    clients.setZipCode("99999");
    clients.setCity("CaremoliCity");
    clients.setCountry("Caremoli");
    clients.setState(1);
    clientsService.save(clients);      

  }
  
}