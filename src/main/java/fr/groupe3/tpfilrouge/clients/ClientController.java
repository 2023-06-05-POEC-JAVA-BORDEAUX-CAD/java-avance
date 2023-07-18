package fr.groupe3.tpfilrouge.clients;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/clients")
@Produces("application/json")
public class ClientController {

	@GET // récupère un client par son identifiant
	@Path("/{id}")
	public ClientDto getClientById(@PathParam("id") Long id) {

		System.out.println(" la methode de recuparation a été appeleée avec l'id " + id);
		ClientDto clientDto = new ClientDto();
		clientDto.setId(id);

		return clientDto;

	}

	@POST // sauvegarde un client
	@Path("/")
	public ClientDto post(@Valid ClientDto clientDto) {

		System.out.println("j'ai un DTO où id est : " + clientDto.getId());
		
		return clientDto;
		
	}

}
