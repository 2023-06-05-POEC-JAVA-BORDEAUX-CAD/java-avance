package Florian.TP_JAXRS;

import Florian.ClientService;
import Florian.TP_entity.ClientEntity;
import Florian.TP_entity.OrderEntity;
import Florian.TP_entity.OrderService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/orders") // Le nom de la ressource est très généralement au pluriel
@Produces("application/json") // Format incontournable en REST
public class OrderRestController {
	
	@Inject
	OrderService orderService;
	@Inject
	ClientService clientService;
	
	@GET
	@Path("/{id}") // L'URL finale sera : classe+méthode
	public Response getOrderRestBean(@PathParam("id") Integer id) {
		System.out.println("La methode de recuperation a ete appelee avec pour id : " + id);
		OrderEntity order = orderService.load(id);
		OrderRestDto orderRestDto = new OrderRestDto();	
		if (id < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		orderRestDto.setTypePresta(order.getTypePresta());
		orderRestDto.setDesignation(order.getDesignation());
		orderRestDto.setClientId(order.getClientId().getId());
		orderRestDto.setNbDays(order.getNbDays());
		orderRestDto.setUnitPrice(order.getUnitPrice());
		orderRestDto.setState(order.getState());
		return Response.ok(orderRestDto).build();
	}

	@PUT
	@Path("/")
	public OrderRestDto put(OrderRestDto orderRestDto) {
		System.out.println("La methode put nous renvoie l'ID: " + orderRestDto.getId());
		return orderRestDto;
	}

/*	@POST
	@Path("/")
	public void post(OrderRestDto orderRestDto) {
		
		ClientEntity clientLoaded = clientService.load(orderRestDto.getClientId());
		System.out.println(clientLoaded.toString());
		if (clientLoaded == null) {
			System.out.println("Le client n'existe pas, Sauvegarde annulée");
			return;
		}
		OrderRestDto orderToSave = orderRestDto.toEntity();
		orderToSave.setId(orderRestDto.getId());
		orderService.save(orderToSave);
	} */
	
	@DELETE
	  @Path("/{id}")
	  public  void deleteOrdersRestBean(@PathParam("id") Integer id){
	    OrderRestDto orderRestDto = new OrderRestDto();
	    System.out.println("La commande avec l'id " +  orderRestDto.getId() + " a été supprimé.");
	  }
}
