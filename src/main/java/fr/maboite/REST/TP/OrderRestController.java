package fr.maboite.REST.TP;

import fr.maboite.exoJPA.Order.OrderEntity;
import fr.maboite.exoJPA.Order.ServiceJpa;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/orders") // Le nom de la ressource est très généralement au pluriel
@Produces(MediaType.APPLICATION_JSON) // Format incontournable en REST
public class OrderRestController {
	
	@Inject
	private ServiceJpa orderService;
	
	@GET
	@Path("/{id}") // L’URL finale sera : application + classe + méthode
	public OrderRestDto getOrder(@PathParam("id") Integer id) {// ← Correspond à {id}
		System.out.println("La méthode de récupération a été appelée avec l'id " + id);
		OrderRestDto orderRestDto = new OrderRestDto();
		OrderEntity loadedOrder = orderService.load(id);
		orderRestDto.setId(loadedOrder.getId());
		orderRestDto.setClientId(loadedOrder.getClientId());
		orderRestDto.setDesignation(loadedOrder.getDesignation());
		orderRestDto.setTypePresta(loadedOrder.getTypePresta());
		//orderRestDto.toEntity();
		//orderRestDto.toService(loadedOrder);
		return orderRestDto;
	}


	@POST
	@Path("/")
	public OrderRestDto post(OrderRestDto orderRestDto) {
		System.out.println("J'ai récupéré un DTO avec l'id : "
				+ orderRestDto.getId()
				+ " le clientId : "
				+ orderRestDto.getClientId()
		+ " la designation : "
		+ orderRestDto.getDesignation()
		+ " le type de prestation : "
		+ orderRestDto.getTypePresta());
		OrderEntity orderEntity = orderRestDto.toEntity();
		orderService.save(orderEntity);
		return orderRestDto;
	}

	@DELETE
	@Path("/{id}") // L’URL finale sera : application + classe + méthode
	public void delete(@PathParam("id") Integer id) {// ← Correspond à {id}
		OrderEntity orderEntity = orderService.load(id);
		orderService.delete(orderEntity);
		System.out.println("La méthode de suppressions a été appelée avec l'id " + id);
	}

}
