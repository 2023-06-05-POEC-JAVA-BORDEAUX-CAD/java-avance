package fr.groupe2.tpcrm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import fr.groupe2.tpcrm.service.ClientService;
import jakarta.inject.Inject;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(
		name="Client",
		displayName="Client Servlet",
		urlPatterns ="/clients",
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
			out.println("<html>"
                    + "<head><title>Client Servlet</title>"
                    + "<style>"
                    + "*{margin: 0; padding: 0;}"
                    + "body{background-color: #333; color: #fff;text-align:center;font-family:sans-serif;}"
                    + "h1{margin: auto; font-size: 50px;}"
                    + "</style>"
                    + "</head>");
            out.println("<body>");
            out.println("<h1>Clients</h1>");	
		
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
			
			out.println("</body></html>");
		}	
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init Client Servlet");
	}
}
