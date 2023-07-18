package fr.groupe3.tpfilrouge.clients;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/clients")
@Produces("application/json")
public class ClientController {

	@Inject
	private ClientService clientService;

	@Inject
	private ClientDto clientDto;

	@GET // récupère un client par son identifiant
	@Path("/{id}")
	public Response getClientById(@PathParam("id") Long id) {

		Client client = clientService.load(id);
		if (client == null) {

			return Response.status(Status.NOT_FOUND).build();
		}

		System.out.println(" la methode de recuparation a été appeleée avec l'id " + id);

		return Response.ok(new ClientDto(client)).build();

	}
	
	@GET // pour recuperer toute la liste des clients
	@Path("/")
	public Response getAllClients( ) { // si je mets en URL clients alors tu recupere tous les clients

		List<Client> clientList = clientService.findAll();
		if (clientList == null) {

			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(clientList).build();

	}
	

	@POST // envoyer en BDD
	@Path("/")
	public Response post(@Valid ClientDto clientDto) {

		if (clientDto == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		Client client = clientDto.toEntity();
		Client savedClient = clientService.save(client);

		return Response.ok(new ClientDto(savedClient)).build();

	}
	
	
	

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		Client client = this.clientService.load(id);
		if (client == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		this.clientService.delete(client);
		return Response.status(Status.OK).build();
	}

}
