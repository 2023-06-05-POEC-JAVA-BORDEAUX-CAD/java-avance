package fr.groupe3.tpfilrouge.commandes;

import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Commande", displayName = "Commande Servlet", urlPatterns = "/orders", loadOnStartup = 1)
public class CommandeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private CommandeService commandeService;
	
	
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		response.setBufferSize(8192);

		String id = request.getParameter("id");
		if (id != null) {
			Integer id_commande = Integer.parseInt(id);

			if (id_commande != null) {
				Commande commande = commandeService.get(id_commande);
				if (commande == null) {
					response.setStatus(404);
					try (PrintWriter out = response.getWriter()) {
						out.println("Erreur 404 : La commande n'existe pas.");
					}
				}				
				String printCommande = commandeService.toJson(commande);
				try (PrintWriter out = response.getWriter()) {
					out.println(printCommande);
				}
			}
		}

		else {
			CommandeDao commandeMap = new CommandeDao();
			Map<Integer, Commande> mapEntiere = commandeMap.getCommandeMap();
			CommandeService mapToJson = new CommandeService();
			String printMap = mapToJson.MapToJson(mapEntiere);
			try (PrintWriter out = response.getWriter()) {
				out.println(printMap);
			}
		}
	}

	@Override
	public String getServletInfo() {
		return "Servlet /orders";
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init /orders terminée");
	}

}