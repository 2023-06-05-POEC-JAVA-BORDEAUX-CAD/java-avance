package fr.fabien.rest.tpfilrouge.controller;

import fr.fabien.rest.tpfilrouge.dto.ExpectedClient;
import fr.fabien.rest.tpfilrouge.dto.ExpectedOrder;
import jakarta.ejb.Stateless;
import jakarta.validation.Valid;
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
	public String getAllClients() {
		return "pathAllClients";
	}

	@GET
	@Path("/{id}") //
	public String getClientById(@PathParam("id") Integer id) {
		System.out.println("ID du client : " + id);
		return "pathClientById";
	}

	@GET
	@Path("/{id}/orders") //
	public String getClientOrders(@PathParam("id") Integer id) {
		System.out.println("liste des commandes du client : " + id);
		return "pathClientOrders";
	}

	@POST
	public String saveClient(@Valid ExpectedClient expectedClient) { // POST
		System.out.println("ID de la commande : " + expectedClient);
		return "pathSaveClient";
	}

	@DELETE
	@Path("/{id}") //
	public String deleteClientById(@PathParam("id") Integer id) { // DELETE
		System.out.println();
		return "PathDeleteClient";
	}

}
