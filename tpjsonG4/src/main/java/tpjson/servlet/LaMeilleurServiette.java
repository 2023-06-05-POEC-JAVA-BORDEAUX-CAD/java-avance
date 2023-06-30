package tpjson.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tpjson.dao.PojoDao;
import tpjson.model.Client;


/**
 * Servlet implementation class LaMeilleurServiette
 */
@WebServlet("/maservlet")
public class LaMeilleurServiette extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LaMeilleurServiette() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// TODO Auto-generated method stub
        response.setContentType("text/html");
        
        PojoDao dao = new PojoDao();
        
        
        HashMap<Integer,Client> mapClient = dao.populateClient(12);
        System.out.println(mapClient);
     
		String json = new ObjectMapper().writeValueAsString(mapClient.get(2));
		System.out.println(json);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Générée par /MASERVLET</title></head>");
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<h2>le client est :  "+ json +"</h2>");
            
            String username = request.getParameter("username");
            if (username != null && username.length() > 0) {
                out.println("Vous êtes : "+ username);
            }
            out.println("</body></html>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	
}
