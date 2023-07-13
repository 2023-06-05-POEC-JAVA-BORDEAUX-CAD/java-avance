package tp.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.sql.SQLException;
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
	@Path("/{id}")
	@Produces("application/json")
	public Client getClientById(@PathParam("id") Integer id) throws SQLException {
		return cliserv.getById(id);
	}
}
