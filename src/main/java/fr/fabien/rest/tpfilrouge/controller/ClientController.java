package fr.fabien.rest.tpfilrouge.controller;

import java.util.ArrayList;
import java.util.List;

import fr.fabien.rest.tpfilrouge.dto.ExpectedClient;
import fr.fabien.tpjsf.jpamodel.ClientModel;
import fr.fabien.tpjsf.jpamodel.OrderModel;
import fr.fabien.tpjsf.jpaservice.ClientService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("/clients") // Le nom de la ressource est très généralement au pluriel
@Produces(MediaType.APPLICATION_JSON) // Format incontournable en REST
public class ClientController {

	@Inject
	private ClientService clientService;

	@GET
	public Response getAllClients() {
		List<ClientModel> allClients = this.clientService.getAll();
		List<ExpectedClient> aClients = new ArrayList<>();
		for (ClientModel c : allClients) {
			aClients.add(ExpectedClient.fromClientModel(c));
		}
		return Response.ok(aClients).build();
	}

	@GET
	@Path("/{id}") //
	public Response getClientById(@PathParam("id") Integer id) {
		ExpectedClient eClient = ExpectedClient.fromClientModel(this.clientService.load(id));
		return Response.ok(eClient).build();
	}

	@GET
	@Path("/{id}/orders") //
	public Response getClientOrders(@PathParam("id") Integer id) {
		ClientModel clientOrders = this.clientService.load(id);
		System.out.println(clientOrders.getOrders());
		for (OrderModel c : clientOrders.getOrders()) {
			c.setClient(null);
		}
		return Response.ok(clientOrders).build();
	}

	@POST
	public String saveClient(@Valid ExpectedClient expectedClient) { // POST
		System.out.println("ID de la commande : " + expectedClient);
		return "pathSaveClient";
	}

	@DELETE
	@Path("/{id}") //
	public String deleteClientById(@PathParam("id") Integer id) { // DELETE
		System.out.println("suppression du client : " + id);
		return "PathDeleteClient";
	}

}
