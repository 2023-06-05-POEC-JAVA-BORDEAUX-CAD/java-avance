package fr.TpSolo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet(name ="jour-ferie", displayName = "Tp Solo jour ferie servlet", urlPatterns ="jour-ferie-result", loadOnStartup = 1)

//@Stateless
public class SoloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	 @Inject
	    private SoloService soloService;
	 
	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        int jour = Integer.parseInt(request.getParameter("j"));
	        int mois = Integer.parseInt(request.getParameter("m"));
	        int annee = Integer.parseInt(request.getParameter("a"));

	        String statutJourFerie = soloService.getStatutJourFerie(jour, mois, annee);

	        response.setContentType("text/html");
	        response.getWriter().println(statutJourFerie);
	    }
}
