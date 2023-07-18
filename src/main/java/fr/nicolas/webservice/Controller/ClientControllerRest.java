package fr.nicolas.webservice.Controller;

import fr.nicolas.jpa.Entity.Client;
import fr.nicolas.jpa.Service.ClientService2;
import fr.nicolas.webservice.DAOMoke.EntityDAOMoke;
import fr.nicolas.webservice.DAOMoke.Error;
import fr.nicolas.webservice.DTO.ClientDTO;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.core.Application;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.validation.Valid;

@Stateless
@ApplicationPath("/rest/v1")
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientControllerRest  extends Application{

	@Inject 
	private ClientService2 clientService;
	
	@GET
	@Path("/{id}")
	public Response getOrderById(@PathParam("id") Integer id) {
		Client client = this.clientService.getClientById(id);
		
		if(client == null) {
			Error err = new Error("404", "Nothin found here");
			return Response.status(Status.NOT_FOUND).entity(err).build();
		}
		ClientDTO clientDTO = new ClientDTO().entityToDTO(client);
		return Response.ok(clientDTO).header("Response", "entity sent").build();
		
	}
	
	
	@POST
	@Path("/")
	public Response post(@Valid ClientDTO clientDTO) {
		Client client = clientDTO.dtoToEntity(clientDTO);
		Client savedClient = this.clientService.save(client);
		if(savedClient == null) {
			Error err = new Error("500", "Internal server error");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).build();
		}
		return Response.ok(savedClient).header("Response", "entity recorded").build();
	}
	
	@PUT
	@Path("/")
	public Response put(@Valid ClientDTO clientDTO) {
		
		Client client = clientDTO.dtoToEntity(clientDTO);
		Client savedClient = this.clientService.save(client);
		if(savedClient == null) {
			Error err = new Error("500", "Internal server error");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).build();
		}
		return Response.ok(savedClient).header("Response", "entity recorded").build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		this.clientService.deleteById(id);
		return Response.ok().build();
	}
}
