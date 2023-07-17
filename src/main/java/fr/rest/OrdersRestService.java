package fr.rest;


import fr.jpa.Clients.Clients;
import fr.jpa.Orders.Orders;
import fr.jpa.Orders.OrdersService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

 

@Stateless
@Path("/orders") // Le nom de la ressource est très généralement au pluriel
@Produces("application/json") //Format incontournable en REST
public class OrdersRestService {
@Inject
private OrdersService orderService;
Clients client;

  @GET
  @Path("/{id}") // L'URL finale sera : classe+méthode
  public Response getOrdersRestBean(@PathParam("id") Integer id) {
    System.out.println("La méthode de récupération a été appelée avec pou id : " + id);
    if (id < 0){ return Response.status(Status.NOT_FOUND).build();
    }       
      
      Orders order = orderService.load(id);
      OrdersRestDto ordersRestDto = new OrdersRestDto();
      ordersRestDto.setId(order.getId());
      ordersRestDto.setTypePresta(order.getTypePresta());
      ordersRestDto.setDesignation(order.getDesignation());
      ordersRestDto.setClientId(order.getClient().getId());  
      ordersRestDto.setNbDays(order.getNbDays());
      ordersRestDto.setUnitPrice(order.getUnitPrice());
      ordersRestDto.setState(order.getState());    
      return Response.ok(ordersRestDto).header("header order", "l'order est la!").build();    
     
  }


  @POST
  @Path("/")
  public OrdersRestDto post(OrdersRestDto ordersRestDto){
    //System.out.println("J'ai récupéré un Dto avec l'id " + ordersRestDto.getId() + " et le type de prestation : " + ordersRestDto.getTypePresta() + " pour " + ordersRestDto.getDesignation());
    Orders order = new Orders();
    order.setId(ordersRestDto.getId());
    order.setTypePresta(ordersRestDto.getTypePresta());
    order.setDesignation(ordersRestDto.getDesignation());
    //Integer clientId = ordersRestDto.getClientId();    
   // order.setClientId(client.setId(clientId));
    order.setNbDays(ordersRestDto.getNbDays());
    order.setUnitPrice(ordersRestDto.getUnitPrice());
    order.setState(ordersRestDto.getState());
    orderService.save(order);    
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
