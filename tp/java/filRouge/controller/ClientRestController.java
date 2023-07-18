package filRouge.controller;

import java.util.List;

import filRouge.Dto.ClientDto;
import filRouge.model.Client;
import filRouge.model.ErrorMessage;
import filRouge.model.Client;
import filRouge.service.ClientService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/clients")
@Produces("application/json")
public class ClientRestController {

	@Inject
	private ClientService clientService;

	@GET
	@Path("/{id}")
	public Response getClient(@PathParam("id") int id) {
		System.out.println("declenchement avec recup id " + id);
		if (id < 0) {
			ErrorMessage erreur = new ErrorMessage();
			erreur.setMessage("erreur !!!");
			return Response.status(Status.NOT_FOUND).entity(erreur).build();
		}
		Client client = clientService.load(id);
		ClientDto clientDto = new ClientDto();
		clientDto.setId(client.getId());
		clientDto.setCity(client.getCity());
		clientDto.setCompanyName(client.getCompanyName());
		clientDto.setEmail(client.getEmail());
		clientDto.setCountry(client.getCompanyName());
		clientDto.setFirstName(client.getFirstName());
		clientDto.setLastName(client.getLastName());
		clientDto.setListOrder(client.getListOrder());
		clientDto.setPhone(client.getPhone());
		clientDto.setAddress(client.getAddress());
		clientDto.setState(client.getState());
		clientDto.setZipCode(client.getZipCode());
		// return clientDto;
		return Response.ok(clientDto).header("reponse", "ca marche").build();

	}

	@GET
	@Path("/")
	public Response getAllClients() {
		List<Client> clients = clientService.findAll();
		return Response.ok(clients).build();
	}

	@POST
	@Path("/post")
	public void post(@Valid Client client) {

		System.out.println("recuperé id: " + client.getId() + " name: " + client.getCompanyName());
	}

	@DELETE
	@Path("/delete/{id}")
	public void delete(int id) {

	}

}
