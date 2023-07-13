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
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/rest/v1/clients")
@Produces("application/json")
public class RestClientController {
	@Inject
	private ClientJpaService cliserv;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClientModel> getClients() throws SQLException {
		return cliserv.getAll();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ClientModel setClient(ClientModel client) throws SQLException {
		return cliserv.save(client);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public ClientModel replaceClient(ClientModel client) throws SQLException {
		return cliserv.save(client);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientModel getClient(@PathParam("id") Integer id) throws SQLException {
		return cliserv.load(id);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientModel deleteClient(@PathParam("id") Integer id) throws SQLException {
		return cliserv.delete(id);
	}
}