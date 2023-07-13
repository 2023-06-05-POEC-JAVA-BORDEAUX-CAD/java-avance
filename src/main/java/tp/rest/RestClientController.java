package tp.rest;

import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import tp.jpa.ClientModel;
import java.sql.SQLException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;
import tp.jpa.ClientJpaService;

@Stateless
@Path("/rest/clients")
@Produces("application/json")
public class RestClientController {
	@Inject
	private ClientJpaService cliserv;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClientModel> getClients() throws SQLException {
		return cliserv.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientModel getClientById(@PathParam("id") Integer id) throws SQLException {
		return cliserv.load(id);
	}
}