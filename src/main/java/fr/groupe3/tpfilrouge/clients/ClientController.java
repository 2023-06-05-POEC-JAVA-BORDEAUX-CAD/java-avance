package fr.groupe3.tpfilrouge.clients;

import jakarta.ejb.Stateless;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;



@Path("/clients") // Le nom de la ressource
@Produces("application/json") 
public class ClientController {

	

		@GET // (recupere l'id
		@Path("/{id}") 
		public ClientDto getClientById(@PathParam("id") Long id) { 

			System.out.println(" la methode de recuparation a été appeleée avec l'id " + id);
			ClientDto clientDto = new ClientDto();
			clientDto.setId(id);
			

			return clientDto;

		}
		
		@POST
		@Path("/")
		public ClientDto post(@Valid ClientDto clientDto) {

			System.out.println("j'ai un DTO où id est : " + clientDto.getId());
			return clientDto;
		}
		
}
	

