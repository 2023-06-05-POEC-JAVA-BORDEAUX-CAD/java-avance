package fr.maboite.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Fab's Welcome page", displayName="Welcome People", urlPatterns = "/fab", loadOnStartup = 1)
public class FabServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Générée par Fabolo</title></head>");
            out.println("<body  bgcolor=\"#ffffff\">"
            		+ "<h1>BOUM, je teste ce que ça donne !!!</h1>"
            		+ "<h2>Coucou, je teste ce que ça donne !!!</h2>"
            		+ "<h2>C'est gavé cool</h2>");
            
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
		System.out.println("Init Fab terminé");
	}
    
    
}