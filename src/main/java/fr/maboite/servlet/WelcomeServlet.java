package fr.maboite.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Welcome1", displayName="Welcome Servlet1", urlPatterns = "/welcome", loadOnStartup = 1)
public class WelcomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			System.out.println(headerNames.nextElement());
		}
		

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Générée par une servlet</title></head>");
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<h2>Quelle belle page générée dynamiquement !!!</h2>");
            
            String username = request.getParameter("username");
            if (username != null && username.length() > 0) {
                out.println("Vous êtes : " + username);
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
		System.out.println("Init terminé");
	}
    
    
}