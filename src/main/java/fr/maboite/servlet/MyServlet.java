package fr.maboite.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.inject.Inject;

import fr.maboite.exercice.JsonMaker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Welcometest", displayName="Test Servlet", urlPatterns = "/welcometest", loadOnStartup = 1)
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    @Inject
    private JsonMaker jsonMaker;
	
    
    
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

            

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Ma serv(i/l)et(te)</title></head>");
            out.println("<body  bgcolor=\"#ddd\">"
                    + "<h2>La servlet (ou serviette si vous êtes Florian) de Coralie</h2>");
            out.println(jsonMaker);
            

            
            
            String username = request.getParameter("username");
            if (username != null && username.length() > 0) {
                out.println("Vous êtes : "+ username);
            }
            out.println("</body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "La première servlet .";

    }

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init my servlet terminé");
	}
    
    
}