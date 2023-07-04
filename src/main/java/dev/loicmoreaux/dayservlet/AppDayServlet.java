package dev.loicmoreaux.dayservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppDayServlet
 */
@WebServlet(name = "Day", displayName = "Day Servlet", urlPatterns = "/appday")
public class AppDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	DayService dayService;
	/**
	 * Default constructor.
	 */
	public AppDayServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath()).append("jour" + dayService.getDayOfWeek(4, 7, 2023));
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			out.println("<html>"
                    + "<head><title>Work or weekend ?</title>"
                    + "<style>"
                    + "*{margin: 0; padding: 0;}"
                    + "body{background-color: #333; color: #fff;text-align:center;font-family:sans-serif;}"
                    + "h1{margin: auto; font-size: 50px;}"
                    + "</style>"
                    + "</head>");
            out.println("<body>");
            out.println("<h1>Work or weekend ?</h1>");
            
            try {
	            int day = Integer.parseInt(request.getParameter("d"));
	            int month = Integer.parseInt(request.getParameter("m"));
	            int year = Integer.parseInt(request.getParameter("y"));
	            
	            out.println("<h2>" + day + "/" + month + "/" + year +"</h2>");
	            out.println("<h2>" + dayService.getDayOfWeek(day, month, year) +"</h2>");
            } catch (NumberFormatException e){
            	out.println("<p>Envoyer une date en paramètre ?d=4&m=7&y=2023</p>");
            } 
            
            out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init App Day ok");
	}
}
