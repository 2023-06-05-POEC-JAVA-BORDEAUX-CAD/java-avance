package fr.groupe3.archives.tpfilrouge.clients;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Welcome Client", displayName = "Client Servlet", urlPatterns = "/clients", loadOnStartup = 1)

public class ClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ClientService clientService;

	@Inject
	private ClientDao clientMap;

	@SuppressWarnings("unused")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		// on verifie que id qui est dans notre getparametre n est pas nul

		if (id != null) {

			Integer idclient = Integer.parseInt(id);

			// on verifie que id a pu etre transformé en idclient donc idclient existe ("id"
			// id qui est " " est un int))

			if (idclient != null) {

				// creation variable de type printwriter qui affiche la reponse
				try (PrintWriter noe = response.getWriter()) {

					Client client = clientService.get(idclient);

					if (client != null) {

						noe.print(clientService.toJson(client));
					} else {
						response.setStatus(404);
					}

				}

			}

		}
		// action si id dans getparemetre est nul (comme s'il n existe pas)
		else {
			Map<Integer, Client> mapEntiere = clientMap.getAllClient();

			// creation d objet printMap pour transformer en Json la ListdesClients
			String printMap = clientService.mapToJson(mapEntiere);
			try (PrintWriter noe1 = response.getWriter()) {
				noe1.println(printMap);
			}

		}

	}

}
