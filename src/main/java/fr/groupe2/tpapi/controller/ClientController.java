package fr.groupe2.tpapi.controller;

import fr.groupe2.tpapi.dto.ClientDto;
import fr.groupe2.tpapi.dto.OrderDto;
import fr.groupe2.tpapi.model.Client;
import fr.groupe2.tpapi.model.Order;
import fr.groupe2.tpapi.service.ClientService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientController {

	@Inject
	private ClientService clientService;

	@GET
	@Path("/{id}")
	public Response getClientById(@PathParam("id") Integer id) {
		// Appel du service pour récupérer
		Client client = this.clientService.getClientById(id);
		if (client == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		// client!=null
		return Response.ok(new ClientDto(client)).build();
	}

	@POST
	@Path("/")
	public Response createOrder(@Valid ClientDto clientDto) {

		if (clientDto == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}


		Client client = clientDto.toEntity();
		if (clientDto.getClientId() != null) {
			Order order = orderService.getById(clientDto.getClientId());

			if (client == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			// le client correspond à un vrai client en base
			client.setOrder(order);
		}
		
		
		
		Client savedClientr = this.clientService.save(client);

		return Response.ok(new ClientDto(savedClient)).build();

	}
	
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		Client client = this.clientService.load(id);
		if (client == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		this.clientService.deleteById(id);
		return Response.status(Status.OK).build();
	}


}
