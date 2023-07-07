package Tp_solo_07_04_inject.copy;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jour-ferie")
public class JourFerieServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
    private JourFerieService jourFerieService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String jourParam = request.getParameter("j");
        String moisParam = request.getParameter("m");
        String anneeParam = request.getParameter("a");
        
        if (jourParam != null && moisParam != null && anneeParam != null) {
            int jour = Integer.parseInt(jourParam);
            int mois = Integer.parseInt(moisParam);
            int annee = Integer.parseInt(anneeParam);
            
            String resultat = jourFerieService.calculerJourFerie(jour, mois, annee);
            
            try {
                response.getWriter().println(resultat);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Gérer les paramètres manquants
        }
    }
}