package fr.maboite.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.inject.Inject;

/**
 * Servlet implementation class PojoJsonServlet
 */
@WebServlet(name="PojoExoservlet",
displayName="Exercice pojoServlet",
urlPatterns = "/pojoExoServ", 
loadOnStartup = 1)

public class PojoJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	@Inject
//       private PojoDao pojodao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PojoJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("pojojson servlet init");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
