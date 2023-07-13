package dev.loicmoreaux.jpa.controller;

import java.util.List;

import dev.loicmoreaux.jpa.model.ClientJpa;
import dev.loicmoreaux.jpa.service.ClientJpaService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
	public ClientJpa getClientbyId(@PathParam("id") Integer id) {
		return this.clientService.getClientById(id);
	}
	
	@GET
	public List<ClientJpa> getClients(){
		return this.clientService.getClients();
	}
}
