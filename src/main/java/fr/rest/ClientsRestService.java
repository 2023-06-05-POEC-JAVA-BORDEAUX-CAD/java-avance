package fr.rest;


import jakarta.ejb.Stateless;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Stateless
@Path("/clients") // Le nom de la ressource est très généralement au pluriel
@Produces("application/json") //Format incontournable en REST
public class ClientsRestService {

  @GET
  @Path("/{id}") // L'URL finale sera : classe+méthode
  public ClientsRestDto getClientsRestBean(@PathParam("id") String id) {
    System.out.println("La méthode de récupération a été appelée  ");
      ClientsRestDto clientsRestDto = new ClientsRestDto();
      clientsRestDto.setId(Integer.decode(id));
      clientsRestDto.setName("Pikachu");
      System.out.println("Le nom de mon client est " + clientsRestDto.getName() + " et son id est " + clientsRestDto.getId());      
      return clientsRestDto;    
     
  }
@POST
  @Path("/")
  public ClientsRestDto post(ClientsRestDto clientsRestDto){
    System.out.println("J'ai récupéré un Dto avec l'id " + clientsRestDto.getId() + " et le nom : " + clientsRestDto.getName());
    return clientsRestDto;
  }

  @DELETE
  @Path("/{id}")
  public  void deleteClientsRestBean(@PathParam("id") String id){
    ClientsRestDto clientsRestDto = new ClientsRestDto();
    clientsRestDto.setId(Integer.decode(id));
    System.out.println("Le client avec l'id " +  clientsRestDto.getId() + " a été supprimé.");
  }

  @PUT
  @Path("/")
  public ClientsRestDto put(ClientsRestDto clientsRestDto){
    System.out.println("J'ai récupéré un Dto avec l'id " + clientsRestDto.getId() + " et le nom : " + clientsRestDto.getName());
    return clientsRestDto;
  }

  
}