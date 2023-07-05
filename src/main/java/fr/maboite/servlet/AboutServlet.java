package fr.maboite.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="About", displayName="About Servlet", urlPatterns = "/about", loadOnStartup = 1)
public class AboutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Test serviette about</title></head>");
            out.println("<body  bgcolor=\"#A6A6A6\">"
                    + "<h2>Quelle belle serviette !!!</h2>");
            
            String username = request.getParameter("username");
            if (username != null && username.length() > 0) {
                out.println("Vous êtes : "+ username);
            }
            out.println("</body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Ma serviette about .";

    }

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init serviette termine");
	}
    
    
}