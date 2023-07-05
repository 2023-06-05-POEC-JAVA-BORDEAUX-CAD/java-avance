package fr.maboite.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Merhaba", displayName="Merhaba Servlet", urlPatterns = "/merhaba", loadOnStartup = 1)
public class EbruServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Générée par une servlet</title></head>");
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<h2>Page Servlet Ebru !!!</h2>");
            
            String username = request.getParameter("username");
            if (username != null && username.length() > 0) {
                out.println("Vous êtes : "+ username);
            }
            out.println("</body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Ilk Servlet .";

    }

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init son");
	}
    
    
}