package fr.noellie.tp;

import java.io.IOException;
import java.io.PrintWriter;

import fr.maboite.correction.pojojsonservlet.pojo.Pojo;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "JourFerie", displayName = "Jour Férié Servlet", urlPatterns = "/jour-ferie", loadOnStartup = 1)
public class JourFerieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private DateService dateService;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.setBufferSize(8192);

		String j = request.getParameter("j");
		Integer jour = Integer.parseInt(j);

		String m = request.getParameter("m");
		Integer mois = Integer.parseInt(m);

		String a = request.getParameter("a");
		Integer annee = Integer.parseInt(a);

		boolean estJourEnSemaine = DateService.jourEnSemaine(jour, mois, annee);

		try {
			String message;
			if (estJourEnSemaine) {
				message = "C'est un jour de la semaine :/";
			} else {
				message = "C'est le week-end ! :)";
			}
			PrintWriter writer = response.getWriter();
			writer.println(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String j = request.getParameter("j");
		Integer jour = Integer.parseInt(j);

		String m = request.getParameter("m");
		Integer mois = Integer.parseInt(m);

		String a = request.getParameter("a");
		Integer annee = Integer.parseInt(a);

//        String nom = request.getParameter("nom");
//        request.setAttribute("nom", nom);

		request.setAttribute("jour", jour);
		request.setAttribute("mois", mois);
		request.setAttribute("annee", annee);

		this.getServletContext().getRequestDispatcher("/WEB-INF/date.jsp").forward(request, response);
	}

	@Override
	public String getServletInfo() {
		return "La servlet indiquant si la date indiquée est en week-end ou en semaine.";

	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init terminé de Jour Férié Servlet");
	}
}