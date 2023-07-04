package fr.TpSolo;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;


/**
 * 
 */

//@WebServlet("/jour-ferie")
public class SoloServlet extends HttpServlet {
	

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
