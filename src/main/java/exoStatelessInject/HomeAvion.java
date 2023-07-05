package exoStatelessInject;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name = "AccueilAvion", displayName = "Accueil Avion", urlPatterns = "/avion", loadOnStartup = 1)

public class HomeAvion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Inject
	private PojoDao pojoDao;
	
	public HomeAvion() {
		super();
	}

	
//    private void doGet() {
//        if (pojoDao == null) {
//            throw new ServletException("Injection of PojoDao failed.");
//        }
//	
//	}
}