package tp.projetfilrouge.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tp.projetfilrouge.service.OrderService;
import tpdate.service.DateService;

@WebServlet(name = "TPPFROS", displayName = "TP PFR Orders Servlet", urlPatterns = "/TPPFR/orders", loadOnStartup = 1)
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private OrderService orderService;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "PrintWriter unavailable");
			return;
		}

		String orderId = request.getParameter("id");

		if (orderId == null) {
			out.println("id" + orderId + ": votre commande n'existe pas. Voici la liste des commandes existantes");

		} else {
			try {
				Integer idInt = Integer.parseInt(orderId);
				out.println("La liste des commandes" + idInt);
			} catch (Exception e) {
				out.println("chaine invalide");
			}
		}

		// parseint
		// try
		// catch

		// ajout

		// récup id dans l'URL

		// si ID==ok alors conversion de id en Integer puis récup de la commande dans
		// OrderService
		// sinon !=ok alors récupération de toutes les commandes avec OrderService
		// affichage de la ou des commandes récupéré au format Json

	}
}
