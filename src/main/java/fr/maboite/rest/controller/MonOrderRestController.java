package fr.maboite.rest.controller;

import fr.maboite.jpa.OrderJpa;
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

@Stateless
@Path("/orders")
@Produces("application/json")
public class MonOrderRestController {

	@Inject
	private MonOrderService monOrderService;

	@GET
	@Path("/{id}")
	public Response getMonOrderRestController(@PathParam("id") Integer id) {

		MonOrderRestDto monOrderRestDto = new MonOrderRestDto();
		OrderJpa entity = monOrderService.load(id);
		if (entity == null || entity.getClientJpa() == null ||entity.getClientJpa().getId() == null || entity.getClientJpa().getId() <= 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("La ressource n'existe pas ou ne possède pas de client valide.").build();
		}

		monOrderRestDto.setDesignation(entity.getDesignation());
		monOrderRestDto.setTypePresta(entity.getTypePresta());

		monOrderRestDto.setClientId(entity.getClientJpa().getId());

		System.out.println("l'id est " + monOrderService.load(id));
		return Response.ok(monOrderRestDto).build();
	}

	@POST
	@Path("/")

	public Response postMonOrderRestBean(@Valid MonOrderRestDto monOrderRestDto) {

		OrderJpa entity = new OrderJpa();
		entity.setDesignation(monOrderRestDto.getDesignation());
		entity.setTypePresta(monOrderRestDto.getTypePresta());
		monOrderService.save(entity);
	   return Response.ok().entity(monOrderRestDto).build();
	}

	@DELETE
	@Path("/id")
	public MonOrderRestDto deleteMonOrderRestBean(MonOrderRestDto monOrderRestDto) {
		
			System.out.println("Nous avons supprimé: id " + monOrderRestDto.getId() 
								+ " nom " + monOrderRestDto.getDesignation());
			return null;
	}

}
