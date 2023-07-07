package tp.projetfilrouge.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tp.projetfilrouge.service.OrderService;
import tp.projetfilrouge.pojo.Order;

@WebServlet(name = "TPPFROS", displayName = "TP PFR Orders Servlet", urlPatterns = "/TPPFR/orders", loadOnStartup = 1)
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private OrderService orderService;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "PrintWriter unavailable");
			return;
		}

		String orderId = request.getParameter("id");

		if (orderId == null) {
			List<Order> order;
			try {
				order = orderService.getAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				out.println("error when order has been getted");
				return;
			}
			String JsonOrder = OrderService.toJson(order);
			out.println(JsonOrder);

		} else {
			try {
				Integer idInt = Integer.parseInt(orderId);
				Order order = orderService.getById(idInt);
				String JsonOrder = OrderService.toJson(order);
				out.println(JsonOrder);
			} catch (Exception e) {
				out.println("order not found");
			}
		}

	}
}
