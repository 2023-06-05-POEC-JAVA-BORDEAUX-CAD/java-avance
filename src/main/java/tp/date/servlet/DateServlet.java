package tp.date.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tp.date.service.DateService;

@WebServlet(name = "jour-ferie", displayName = "TP Jour ferie Servlet", urlPatterns = "/jour-ferie-result", loadOnStartup = 1)
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private DateService date;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		Integer j, m, a;
		try {
			j = Integer.parseInt(request.getParameter("j"));
			m = Integer.parseInt(request.getParameter("m"));
			a = Integer.parseInt(request.getParameter("a"));
			out = response.getWriter();
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid or missing j, m or a.");
			return;
		}

		response.setContentType("text/html");
		if (this.date.isWeek(j, m, a)) {
			out.println("C'est le week-end !");
		} else {
			out.println("Ce n'est pas le week-end !");
		}
	}
}
