package TP_solo;



import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;

import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import jakarta.inject.Named;
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
	
	public class TPSoloServlet extends HttpServlet {
		

		private static final long serialVersionUID = 1L;

		@Inject
		private TPService tpService;

		private TPToJson tpToJson = new TPToJson();

		@Override
		public void doGet(HttpServletRequest request,
				HttpServletResponse response)
				throws ServletException, IOException {

			response.setContentType("application/json");
			response.setBufferSize(8192);

			int jour = request.getParameter("j");
			int mois = request.getParameter("m");
			int annee = request.getParameter("a");
			
			LocalDate date= LocalDate.of(annee, mois, jour);
			
			

			
			if (date.getDayofWeek()==DayOfWeek.SATURDAY || date.getDayofWeek()==DayOfWeek.MONDAY) {
				
				System.out.println()"c'est le we");
	
				else {
					
				return  "c'est jour travaillé";
				
				
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
	


