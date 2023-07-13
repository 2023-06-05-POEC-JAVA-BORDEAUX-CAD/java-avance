package tp.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.sql.SQLException;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import tp.projetfilrouge.pojo.Client;
import tp.projetfilrouge.service.ClientService;

@Stateless
@Path("/rest/clients")
@Produces("application/json")
public class RestClientController {
	@Inject
	private ClientService cliserv;

	@GET
	@Produces("application/json")
	public List<Client> getClients() throws SQLException {
		return cliserv.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Client getClientById(@PathParam("id") Integer id) throws SQLException {
		return cliserv.getById(id);
	}
}
