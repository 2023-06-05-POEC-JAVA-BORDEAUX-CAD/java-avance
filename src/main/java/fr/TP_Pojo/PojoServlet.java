package fr.TP_Pojo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Welcome Pojo", displayName = "Pojo Servlet", urlPatterns = "/pojo", loadOnStartup = 1)
public class PojoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private PojoDao pojoDao;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");

		response.setBufferSize(8192);

		// si on ne mets pas "id" dans URL alors getparametre renvoi null
		// ?: parametre de recherche dans URL, on peut chercher plusierus parametres au
		// meme temps

		// Integer id_pojo;

//		try { 
//			
//			id_pojo=Integer.parseInt(id);
//			
//			
//		} catch (Exception e) {
//			
//			try (PrintWriter out = response.getWriter()) {
//				out.println("veuillez renseigner un id");
//
//			}
//			
//			return ;
//		}
//		

		String id = request.getParameter("id"); // regarde dans URL si le parametre qui est " " s'il existe,
		// getparametre retourne soit null, soit string

		Integer id_pojo = Integer.parseInt(id);

		Pojo test = pojoDao.getPojo(id_pojo); // return un Pojo ou null

		PojoToJson pojoToJson = new PojoToJson();
		String messagepojo = pojoToJson.toJson(test);
		System.out.println(messagepojo);

		
		
		//
		try (PrintWriter alexis = response.getWriter()) { 
			alexis.println(messagepojo);

		}

	}

	@Override
	public String getServletInfo() {
		return "La première servlet .";

	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init terminé");
	}

}