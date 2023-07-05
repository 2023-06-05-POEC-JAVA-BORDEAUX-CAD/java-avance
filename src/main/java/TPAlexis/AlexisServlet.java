package TPAlexis;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Welcome EBRU", displayName = "Alexis Servlet", urlPatterns = "/weekend", loadOnStartup = 1)
public class AlexisServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlexisService alexis;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// on reecrit et remplace la methode doGet

		String jour = request.getParameter("j");
		String mois = request.getParameter("m");
		String annee = request.getParameter("a");

		Integer numjour = Integer.parseInt(jour);
		Integer nummois = Integer.parseInt(mois);
		Integer numannee = Integer.parseInt(annee);

		try (PrintWriter ebru = response.getWriter()) {

			if (alexis.isWeekEnd(numjour, nummois, numannee)) {

				ebru.println("c'est le we");

			} else {
				ebru.println("c'est pas le we");
			}

		}

	}

}
