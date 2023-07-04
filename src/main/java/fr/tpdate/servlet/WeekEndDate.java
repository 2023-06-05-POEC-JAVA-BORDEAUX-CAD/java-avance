package fr.tpdate.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import fr.tpdate.service.DateService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WeekEndDate
 */
@WebServlet(name = "weekenddate", displayName = "weekend date", urlPatterns = "/weekend", loadOnStartup = 1)
public class WeekEndDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	DateService dateService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeekEndDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setBufferSize(8192);

		try (PrintWriter out = response.getWriter()) {

			out.println("<html>"
					+ "<head><title>Hello Cat !</title>"
					+ "<style>"
					+ "*{margin: 0; padding: 0;}"
					+ "body{background-color: #333; color: #fff;text-align:center;font-family:sans-serif;}"
					+ "h1{margin: auto; font-size: 50px;}"
					+ "form {display:flex; flex-direction:column; width:300px; margin-right:auto; margin-left:auto;}"
					+ "</style>"
					+ "</head>");
			out.println("<body>");
			out.println("<h1>Est ce que cette date est dans un weekend ?</h1>");
			String day = request.getParameter("j");
			String month = request.getParameter("m");
			String year = request.getParameter("a");
		
			if(day!=null && day.length()>0 && day!=null && day.length()>0 && day!=null && day.length()>0) {
				out.println("<p>" + dateService.isThisDateIsInWeekend(day, month, year) + "<p>");
			} else {
				out.println("Erreur : Tous les paramètres attendus ne sont pas présents !");
				out.println("<form action='' method='post'>");
				out.println("<label for='day'>Jour</label>");
				out.println("<input type='text' id='day'>");
				out.println("<label for='month'>Mois</label>");
				out.println("<input type='text' id='month'>");
				out.println("<label for='year'>Année</label>");
				out.println("<input type='text' id='year'>");
				out.println("<input type='submit' value='Envoyer'>");
				out.println("</form>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		
		if(day!= null && month!=null&& year!=null) {
            response.sendRedirect("weekend?j="+day+"&&m="+month+"&&a="+year);
		}
	}

}
