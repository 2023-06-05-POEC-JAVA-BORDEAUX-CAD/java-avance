package fr.groupe2.tpcrm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import fr.groupe2.tpcrm.service.OrderService;
import jakarta.inject.Inject;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet(name = "OrderServlet", displayName = "Order Servlet", urlPatterns = "/orders", loadOnStartup = 1)
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private OrderService orderService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try (PrintWriter out = response.getWriter()) {
			out.println("<html>"
                    + "<head><title>Order Servlet</title>"
                    + "<style>"
                    + "*{margin: 0; padding: 0;}"
                    + "body{background-color: #333; color: #fff;text-align:center;font-family:sans-serif;}"
                    + "h1{margin: auto; font-size: 50px;}"
                    + "</style>"
                    + "</head>");
            out.println("<body>");
            out.println("<h1>Orders</h1>");			
			
			String id = request.getParameter("id");
			if (id != null) {
				try {
					Integer intId = Integer.valueOf(id);
					String orderToString = orderService.getOrderByIdToString(intId);
					if (orderToString != null) {
						out.println("<p>" + orderToString + "</p>");
					} else {
						response.setStatus(404);
						out.println("<p class=\"error\">Erreur 404</p>");
					}
				} catch (NumberFormatException e) {
					out.println("<p class=\"error\">Le format de l'id est incorrect</p>");
				}
			} else {
				out.println("<p>Affichage de la liste des commandes</p>");
				String ordersToString = orderService.getOrdersToString();

				if (ordersToString != null) {
					out.println("<p>" + ordersToString + "</p>");
				} else {
					response.setStatus(404);
					out.println("<p class=\"error\">Erreur 404</p>");
				}
			}
			
			out.println("</body></html>");
		}
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init Order Servlet");
	}
}
