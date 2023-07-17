package tp.rest;

import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import tp.jpa.ClientModel;
import jakarta.ws.rs.DELETE;
import java.sql.SQLException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import tp.jpa.ClientJpaService;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/rest/v1/clients")
@Produces("application/json")
public class RestClientController {
	@Inject
	private ClientJpaService cliserv;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClients() throws SQLException {
		List<ClientModel> clients = cliserv.getAll();
		return Response.ok(clients).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response setClient(ClientModel client) throws SQLException {
		ClientModel saved = cliserv.save(client);
		if (saved.getId() == 1) { // comme j'ai pas d'id < 0
			return Response.status(Status.BAD_REQUEST).entity(new BadRequest()).build();
		}
		return Response.ok(saved).header("Secure-key", "f1a49b3").build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response replaceClient(ClientModel client) throws SQLException {
		ClientModel saved = cliserv.save(client);
		return Response.ok(saved).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClient(@PathParam("id") Integer id) throws SQLException {
		ClientModel loaded = cliserv.load(id);
		return Response.ok(loaded).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteClient(@PathParam("id") Integer id) throws SQLException {
		ClientModel deleted = cliserv.delete(id);
		return Response.ok(deleted).build();
	}
}