package fr.groupe3.tpfilrouge.orders;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
public class OrdersRestController {
@Inject
private OrdersService orderService;
private ClientService clientService;


  /**
	 * Mappe GET /orders/{id}
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	public Response getOrders(@PathParam("id") Integer id) {
		//Appel du service pour récupérer
		Orders order = this.orderService.load(id);
		if (order == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		//order!=null
		return Response.ok(new OrdersDto(order))
				.build();
	}   
  

  @GET
  @Path("/")
  public Response getAllOrders(){
    List<Orders> order = this.orderService.findAll();
    if (order == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		//order!=null
		return Response.ok(order).build();
  }

@POST
@Path("/")
public Response post(@Valid OrdersDto orderDto) {
		
		if (orderDto == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Orders order = orderDto.toEntity();

		if (orderDto.getClientId() != null) {
			Client client = clientService.getById(orderDto.getClientId());
			if (client == null) {
				return Response
						.status(Status.BAD_REQUEST)
						.entity(
								new ErrorRestImmutableDto("requête invalide",
										"client non trouvé",
										"clientId : " + orderDto.getClientId() + " ne correpond à aucun client."))
						.build();
			}
			//le client correspond à un vrai client en base
			order.setClient(client);
		}

		Orders savedOrder = this.orderService.save(order);
		
		return Response.ok(new OrdersDto(savedOrder))
				.build();
	}

  @DELETE
  @Path("/{id}")
  public  Response deleteOrdersRestBean(@PathParam("id") Integer id){
    Orders order = this.orderService.load(id);
		if(order == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		this.orderService.delete(id);
		return Response.status(Status.OK).build();
	} 
}

