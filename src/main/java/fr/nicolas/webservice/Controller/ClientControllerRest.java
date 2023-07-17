package fr.nicolas.webservice.Controller;

import fr.nicolas.jpa.Entity.Client;
import fr.nicolas.jpa.Service.ClientService2;
import fr.nicolas.webservice.DAOMoke.EntityDAOMoke;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.core.Application;
import jakarta.inject.Inject;
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

@Stateless
@ApplicationPath("/rest/v1")
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientControllerRest  extends Application{

	@Inject 
	private ClientService2 clientService;
	
	@GET
	@Path("/{id}")
	public EntityDAOMoke getOrderById(@PathParam("id") Integer id) {
		EntityDAOMoke entityDAOMoke = new EntityDAOMoke(1,"LOL");
		return entityDAOMoke;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getOrderByIdPlain(@PathParam("id") Integer id) {
		EntityDAOMoke entityDAOMoke = new EntityDAOMoke(1,"LOL");
		return entityDAOMoke.toString();
	}
	
	@GET
	@Path("db/{id}")
	public Client getOrderByIdDb(@PathParam("id") Integer id) {
		return this.clientService.getClientById(id);
	}
	
	
	@POST
	@Path("/")
	public EntityDAOMoke post(EntityDAOMoke entityDAOMoke) {
		return entityDAOMoke;
	}
	
	@PUT
	@Path("/")
	public EntityDAOMoke put(EntityDAOMoke entityDAOMoke) {
		return entityDAOMoke;
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		return Response.ok().build();
	}
}
