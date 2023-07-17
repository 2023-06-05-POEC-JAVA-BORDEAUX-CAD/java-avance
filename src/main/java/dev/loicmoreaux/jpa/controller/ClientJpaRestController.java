package dev.loicmoreaux.jpa.controller;

import java.util.List;

import dev.loicmoreaux.jpa.dto.ClientJpaDto;
import dev.loicmoreaux.jpa.model.ClientJpa;
import dev.loicmoreaux.jpa.service.ClientJpaService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;


@Stateless
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientJpaRestController {
	
	@Inject
	ClientJpaService clientService;
	
	@GET
	@Path("/test")
	public String getTest() {
		return "Test clients ok";
	}
	
	@GET
	@Path("/{id}")
	public Response getClientbyId(@PathParam("id") Integer id) {
		//return this.clientService.getClientById(id);
		ClientJpa client = this.clientService.getClientById(id);
		
		if(client == null) {
			return Response.status(Status.NOT_FOUND).entity(new MessageRestJpa("Auncun client n'a été trouvé avec l'id : " + id)).build();
		} 
		
		ClientJpaDto clientDto = new ClientJpaDto(client);
		return Response.ok(clientDto).build();
	}
	
	@GET
	public List<ClientJpa> getClients(){
		return this.clientService.getClients();
	}
}
