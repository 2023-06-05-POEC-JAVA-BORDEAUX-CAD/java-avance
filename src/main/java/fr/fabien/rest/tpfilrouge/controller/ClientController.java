package fr.fabien.rest.tpfilrouge.controller;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/clients") // Le nom de la ressource est très généralement au pluriel
@Produces(MediaType.APPLICATION_JSON) // Format incontournable en REST
public class ClientController {

	@GET
	public String getAllClients()  {
		return "pathAllClients";
	}
	@GET
	@Path("/{id}") // 
	public String getClientById(@PathParam("id") Integer id) {
		return "pathClientById";
	}
	
	@GET
	@Path("/{id}") // 
	public String getClientOrders(@PathParam("id") Integer id) {
		return "pathClientOrders";
	}
	@POST
	public String saveClient() { // POST
		return "pathSaveClient";
	}
	
	@DELETE
	@Path("/{id}") // 
	public String deleteClientById(@PathParam("id") Integer id) { // DELETE
		return "";
	}
	
	
	
	
}
