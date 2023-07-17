package tp.rest;

import tp.jpa.ClientModel;
import tp.jpa.ClientJpaService;

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
@Path("/clients")
@Produces("application/json")
public class RestClientController {
	@Inject
	private ClientJpaService cliserv;

	private CustomResponse not_found = new CustomResponse(404, "Client not found");

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClients() throws SQLException {
		List<ClientModel> clients = cliserv.getAll();
		return Response.ok(clients).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response setClient(@Valid ClientModel client) throws SQLException {
		ClientModel saved = cliserv.save(client);
		return Response.ok(saved).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response replaceClient(@Valid ClientModel client) throws SQLException {
		ClientModel saved = cliserv.save(client);
		return Response.ok(saved).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClient(@PathParam("id") Integer id) throws SQLException {
		ClientModel loaded = cliserv.load(id);
		if (loaded == null) {
			return Response.status(Status.NOT_FOUND).entity(not_found).build();
		}
		return Response.ok(loaded).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteClient(@PathParam("id") Integer id) throws SQLException {
		ClientModel deleted = cliserv.delete(id);
		if (deleted == null) {
			return Response.status(Status.NOT_FOUND).entity(not_found).build();
		}
		return Response.ok(deleted).build();
	}
}