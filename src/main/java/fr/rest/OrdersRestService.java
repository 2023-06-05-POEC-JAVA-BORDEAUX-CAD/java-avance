package fr.rest;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Stateless
@Path("/orders") // Le nom de la ressource est très généralement au pluriel
@Produces("application/json") //Format incontournable en REST
public class OrdersRestService {

  @GET
  @Path("/{id}") // L'URL finale sera : classe+méthode
  public OrdersRestDto getOrdersRestBean(@PathParam("id") String id) {
    System.out.println("La méthode de récupération a été appelée  ");
      OrdersRestDto ordersRestDto = new OrdersRestDto();
      ordersRestDto.setId(Integer.decode(id));
      ordersRestDto.setTypePresta("Formation");
      ordersRestDto.setDesignation("Rest initiation");
      System.out.println("Le type de prestation de ma commande est " + ordersRestDto.getTypePresta() +  " pour " +
      ordersRestDto.getDesignation() + " et son id est " + ordersRestDto.getId());      
      return ordersRestDto;    
     
  }
@POST
  @Path("/")
  public OrdersRestDto post(OrdersRestDto ordersRestDto){
    System.out.println("J'ai récupéré un Dto avec l'id " + ordersRestDto.getId() + " et le type de prestation : " + ordersRestDto.getTypePresta() + " pour " + ordersRestDto.getDesignation());
    return ordersRestDto;
  }

  @DELETE
  @Path("/{id}")
  public  void deleteOrdersRestBean(@PathParam("id") String id){
    OrdersRestDto ordersRestDto = new OrdersRestDto();
    ordersRestDto.setId(Integer.decode(id));
    System.out.println("La commande avec l'id " +  ordersRestDto.getId() + " a été supprimé.");
  }
  

 
  

  
}
