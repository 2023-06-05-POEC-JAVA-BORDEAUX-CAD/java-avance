package tp.rest;

import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import tp.jpa.OrderModel;
import jakarta.ws.rs.DELETE;
import java.sql.SQLException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import tp.jpa.OrderJpaService;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/rest/v1/orders")
@Produces("application/json")
public class RestOrderController {
	@Inject
	private OrderJpaService ordserv;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderModel> getClients() throws SQLException {
		return ordserv.getAll();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public OrderModel setClient(OrderModel client) throws SQLException {
		return ordserv.save(client);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public OrderModel replaceClient(OrderModel client) throws SQLException {
		return ordserv.save(client);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public OrderModel getClient(@PathParam("id") Integer id) throws SQLException {
		return ordserv.load(id);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public OrderModel deleteClient(@PathParam("id") Integer id) throws SQLException {
		return ordserv.delete(id);
	}
}
