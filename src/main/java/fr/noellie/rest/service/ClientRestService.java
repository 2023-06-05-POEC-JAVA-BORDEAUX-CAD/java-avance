package fr.noellie.rest.service;

import fr.noellie.jpa.model.ClientJPA;
import fr.noellie.jpa.service.ClientJPAService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Stateless
@Path("/clients")
@Produces("application/json")
public class ClientRestService {
	@Inject
	ClientJPAService clientService;

//	@GET
//	@Path("/{id}")
//	@Produces("application/json")
//	public ClientJPA getclientById(@PathParam("id") String id) {
//		return toClientRestDto(this.clientService.findById(Integer.decode(id)));
//	}
}