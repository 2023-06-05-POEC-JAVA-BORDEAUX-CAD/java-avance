package tp.pojodao;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Map<String, String> langues = new HashMap<>();
// https://docs.oracle.com/javase/8/docs/api/java/util/Map.html

@WebServlet(name = "Accueil", displayName = "Accueil du TP", urlPatterns = "/", loadOnStartup = 1)
public class Home extends HttpServlet {
	private PojoDao dao = new PojoDao();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StringId = request.getParameter("pojo");
		if (StringId == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "the Pojo ID is missing");
			return;
		}

		Integer IntegerId;
		try {
			IntegerId = Integer.parseInt(StringId);
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "the Pojo ID is not a valid number");
			return;
		}

		Pojo pojo = this.dao.getPojo(IntegerId);

		if (pojo == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "the ID doesn't match any Pojo");
			return;
		}

		response.setContentType("application/json");
		try (PrintWriter out = response.getWriter()) {
			out.println(PojoToJson.toJson(pojo));
		}
	}
}