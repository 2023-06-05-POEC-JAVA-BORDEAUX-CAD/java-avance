package tp.rest;

import tp.jpa.OrderModel;
import tp.jpa.OrderJpaService;

import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.DELETE;
import java.sql.SQLException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/orders")
@Produces("application/json")
public class RestOrderController {
	@Inject
	private OrderJpaService ordserv;

	private CustomResponse not_found = new CustomResponse(404, "Order not found");

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrders() throws SQLException {
		List<OrderModel> orders = ordserv.getAll();
		return Response.ok(orders).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response setOrder(@Valid ExpectedOrder order) throws SQLException {
		OrderModel saved = ordserv.save(order.tOrderModel());
		return Response.ok(saved).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response replaceOrder(@Valid ExpectedOrder order) throws SQLException {
		OrderModel saved = ordserv.save(order.tOrderModel());
		return Response.ok(saved).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrder(@PathParam("id") Integer id) throws SQLException {
		OrderModel loaded = ordserv.load(id);
		if (loaded == null) {
			return Response.status(Status.NOT_FOUND).entity(not_found).build();
		}
		return Response.ok(loaded).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteOrder(@PathParam("id") Integer id) throws SQLException {
		OrderModel deleted = ordserv.delete(id);
		if (deleted == null) {
			return Response.status(Status.NOT_FOUND).entity(not_found).build();
		}
		deleted.setClient(null);
		return Response.ok(deleted).build();
	}
}
