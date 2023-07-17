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
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response.Status;

class Success {
	public int code = 200;
	public String reason = "OK";
}

@Stateless
@Path("/clients")
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
	public Response setClient(@Valid ClientModel client) throws SQLException {
		// ClientModel saved = cliserv.save(client);
		// return Response.ok(saved).build();
		return Response.ok(new Success()).build();
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
		if (loaded.getId() == 1) {
			return Response.status(Status.BAD_REQUEST).entity(new BadRequest()).build();
		}
		return Response.ok(loaded).header("Secure-key", "f1a49b3").build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteClient(@PathParam("id") Integer id) throws SQLException {
		ClientModel deleted = cliserv.delete(id);
		return Response.ok(deleted).build();
	}
}