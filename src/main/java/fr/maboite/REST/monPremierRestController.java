package fr.maboite.REST;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

	
@Stateless
@Path("/clients") // Le nom de la ressource est très généralement au pluriel
@Produces("application/json") // Format incontournable en REST
public class monPremierRestController {
 
    @GET
    @Path("/{id}") // L'URL finale sera : classe+méthode
    public monDto getMonPremierRestBean() {
    	System.out.println("La méthode de récupération a été appelée  ");
    	monDto monPremierRestDto = new monDto();
        monPremierRestDto.setId(12l);
        monPremierRestDto.setName("Simon !");
        System.out.println("L'id est  " + monPremierRestDto.getId());
        System.out.println("Le nom est  " + monPremierRestDto.getName());
        return monPremierRestDto;
        
    }
    
    @POST
	@Path("/")
	public monDto post(monDto monPremierRestDto) {
    	System.out.println("L'id est  " + monPremierRestDto.getId());
        System.out.println("Le nom est  " + monPremierRestDto.getName());
    	return monPremierRestDto;
    }
    
    @DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) {
		System.out.println("La méthode de suppressions a été appelée avec l'id " + id);
	}
    
}


