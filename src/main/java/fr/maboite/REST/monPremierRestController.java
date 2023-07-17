package fr.maboite.REST;

import jakarta.ejb.Stateless;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

	
@Stateless
@Path("/clients") // Le nom de la ressource est très généralement au pluriel
@Produces("application/json") // Format incontournable en REST
public class monPremierRestController {
 
    @GET
    @Path("/{id}") // L'URL finale sera : classe+méthode
    public Response getMonPremierRestBean(@PathParam("id") Long id) {
    	System.out.println("La méthode de récupération a été appelée  ");
    	
    	if(id<0)
    	{
    		return Response.status(Status.NOT_FOUND).build();
    	}
    	monDto monPremierRestDto = new monDto();
    	
        monPremierRestDto.setId(12l);
        monPremierRestDto.setName("Simon !");
        
        return Response.ok(monPremierRestDto).header("Etat", "Tout est ok").build();
        
    }
    
    @POST
	@Path("/")
	public monDto post(@Valid monDto monPremierRestDto) {
    	System.out.println("L'id est  " + monPremierRestDto.getId());
        System.out.println("Le nom est  " + monPremierRestDto.getName());
    	return monPremierRestDto;
    }
    
    @PUT
	@Path("/{id}")
	public void put(@PathParam("id") Long id) {
    	System.out.println("La méthode de modification a été appelée avec l'id " + id);
    	//return monPremierRestDto;
    }
    
    @DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) {
		System.out.println("La méthode de suppressions a été appelée avec l'id " + id);
	}
    
}


