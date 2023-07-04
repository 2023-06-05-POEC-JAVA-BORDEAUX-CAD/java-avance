package fr.TP_Pojo;

import java.io.IOException;
import java.io.PrintWriter;

//import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Pojo", displayName = "Pojo Servlet", urlPatterns = "/pojotp", loadOnStartup = 1)
public class PojoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//@Inject
	private PojoDao pojoDao = new PojoDao();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		response.setBufferSize(8192);

		String id = request.getParameter("id");
		Integer id_pojo = Integer.parseInt(id);

		if (id_pojo != null) {
			Pojo test = pojoDao.getPojo(id_pojo);
			PojoToJson pojoToJson = new PojoToJson();
			String printPojo = pojoToJson.toJson(test);
			System.out.println(printPojo);

			try (PrintWriter out = response.getWriter()) {
				out.println(printPojo);
			}
		}
	}

	@Override
	public String getServletInfo() {
		return "La première servlet .";

	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init terminé Tp Pojo");
	}

}