package fr.maboite.correction.pojojsonservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import fr.maboite.correction.pojojsonservlet.json.PojoToJson;
import fr.maboite.correction.pojojsonservlet.pojo.Pojo;
import fr.maboite.correction.pojojsonservlet.service.PojoService;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet agissant quand une requête /pojo?id=XXX doit être traitée. Renvoie en
 * JSON une instance de POJO avec l'id XXX, ou une réponse 404 si aucune n'est
 * trouvée.
 */
@WebServlet(name = "PojoJson", 
displayName = "Pojo to JSON Servlet", 
urlPatterns = "/pojo", 
loadOnStartup = 1)
public class PojoJsonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private PojoService pojoService;

	private PojoToJson pojoToJson = new PojoToJson();

	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setBufferSize(8192);

		String idParameter = request.getParameter("id");
		if (idParameter != null && idParameter.length() > 0) {
			try {
				Integer id = Integer.parseInt(idParameter);
				Pojo pojo = pojoService.get(id);
				if (pojo != null) {
					try (PrintWriter out = response.getWriter()) {
						out.print(pojoToJson.toJson(pojo));
						return;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Si nous arrivons ici, c'est qu'une erreur est survenue plus haut
		// et que l'instruction return n'a pas été exécutée
		response.setStatus(404);

	}

	@Override
	public String getServletInfo() {
		return "La servlet envoyant les POJOs en JSON .";

	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init terminé de PojoToJsonServlet");
	}

}