package fr.nicolas.webservice.Controller;

import jakarta.ejb.Stateless;
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
import fr.nicolas.jpa.Entity.Order;
import fr.nicolas.jpa.Service.OrderService;
import fr.nicolas.webservice.DAOMoke.EntityDAOMoke;
import fr.nicolas.webservice.DAOMoke.Error;
import fr.nicolas.webservice.DTO.OrderDTO;
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
	public Response getOrderById(@PathParam("id") Integer id) {
		Order order = this.orderService.getOrderById(id);
		
		if(id<1 || order == null) {
			Error err = new Error("404", "Nothin found here");
			return Response.status(Status.NOT_FOUND).entity(err).build();
		}
		OrderDTO orderDTO = new OrderDTO().entityTODTO(order);
		return Response.ok(orderDTO).header("Response", "entity sent").build();
	}

	
	@POST
	@Path("/")
	public Response post(@Valid OrderDTO orderDTO) {	
		
		Order order = orderDTO.DtoToEntity(orderDTO);
		Order savedOrder = this.orderService.save(order);
		
		if(savedOrder == null) {
			Error err = new Error("500", "Internal server error");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).build();
		}
		
		return Response.ok(savedOrder).header("Response", "entity recorded").build();
	}
	
	@PUT
	@Path("/")
	public Response put(@Valid OrderDTO orderDTO) {
		Order order = orderDTO.DtoToEntity(orderDTO);
		Order savedOrder = this.orderService.save(order);
		
		if(savedOrder == null) {
			Error err = new Error("500", "Internal server error");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).build();
		}
		return Response.ok(savedOrder).header("Response", "entity recorded").build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		this.orderService.deleteById(id);
		return Response.ok().build();
	}
	
}
