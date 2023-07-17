package fr.nicolas.webservice.Controller;

import jakarta.ejb.Stateless;
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
import fr.nicolas.jpa.Entity.Order;
import fr.nicolas.jpa.Service.OrderService;
import fr.nicolas.webservice.DAOMoke.EntityDAOMoke;
import jakarta.ws.rs.core.Application;

@Stateless
@ApplicationPath("/rest/v1")
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderControllerREST extends Application{

	@Inject 
	private OrderService orderService;
	
	
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
	public Order getOrderByIdDb(@PathParam("id") Integer id) {
		
		//return Response.ok().build();
		Order fetchedOrder = this.orderService.getOrderById(id);
		System.out.println(fetchedOrder.getClient().getAddress()); 
		return fetchedOrder;
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
