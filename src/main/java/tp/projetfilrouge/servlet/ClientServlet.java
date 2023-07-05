package tp.projetfilrouge.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "TPPFRCS", displayName = "TP PFR Clients Servlet", urlPatterns = "/TPPFR/clients", loadOnStartup = 1)
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "PrintWriter unavailable");
			return;
		}
		out.println("Hello sur la page clients");
	}
}
