package tp.projetfilrouge.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.inject.Inject;
import tp.projetfilrouge.pojo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import tp.projetfilrouge.service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "TPPFRCS", displayName = "TP PFR Clients Servlet", urlPatterns = "/TPPFR/clients", loadOnStartup = 1)
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ClientService client;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "PrintWriter unavailable");
			return;
		}

		String idRecup = request.getParameter("id");

		if (idRecup == null) {

			// Recup de tous les clients dans une liste

			try {
				List<Client> allClients = client.getAll();
				String JsonClients = ClientService.toJson(allClients);
				out.println(JsonClients);

			} catch (Exception e) {
				out.println("Une erreur SQL a eu lieu");
				out.println(e.getMessage());
			}
			// Transformation de la liste de clients en Json

			// public static String toJson(List<Client> allClients) throws
			// JsonProcessingException {
			// return new ObjectMapper().writeValueAsString(allClients);

		} else

		{
			try {
				Integer idInt = Integer.parseInt(idRecup);
				Client cli = client.getById(idInt);
				if (cli == null) {
					out.println("cet Id n\'est attribué a aucun client");
				} else {
					String JsonClient = ClientService.toJson(cli);
					out.println(JsonClient);
				}

			} catch (Exception e) {
				out.println("chaine invalide, id n\'est pas un nombre");
			}
		}
	}
}
