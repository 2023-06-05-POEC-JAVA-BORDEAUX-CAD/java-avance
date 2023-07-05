package fr.groupe2.tpcrm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.groupe2.tpcrm.service.ClientService;
import jakarta.inject.Inject;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(
		name="Client",
		displayName="Client Servlet",
		urlPatterns="/clients",
		loadOnStartup=1)
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private ClientService clientService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		try(PrintWriter out = response.getWriter()){
		
			String id = request.getParameter("id");
			if(id != null) {
				try {
					Integer intId = Integer.parseInt(id);
					
					String clientToString = clientService.getClientByIdToString(intId);
					if(clientToString != null) {
						out.println("<p>" + clientToString + "</p>");
					} else {
						response.setStatus(404);
						out.println("<p class=\"error\">Erreur 404</p>");
					}
					
				} catch (NumberFormatException e) {
					out.println("<p class=\"error\">Le format de l'id est incorrect</p>");
				}
			} else {
				out.println("<p>Affichage de la liste des clients</p>");
				String clientsToString = clientService.getClientsToString();
				if(clientsToString != null) {
					out.println("<p>" + clientsToString + "</p>");
				} else {
					response.setStatus(404);
					out.println("<p class=\"error\">Erreur 404</p>");
				}
				
			}
		}	
	}
}
