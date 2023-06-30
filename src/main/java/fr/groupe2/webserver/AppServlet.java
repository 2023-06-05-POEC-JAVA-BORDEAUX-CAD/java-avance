package fr.groupe2.webserver;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Cat", displayName="Cat Servlet", urlPatterns = "/cat", loadOnStartup = 1)
public class AppServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Hello Cat !</title>"
                    + "<style>"
                    + "*{margin: 0; padding: 0;}"
                    + "body{background-color: #333; color: #fff;text-align:center;font-family:sans-serif;}"
                    + "h1{margin: auto; font-size: 50px;}"
                    + "</style>"
                    + "</head>");
            out.println("<body>");
            out.println("<h1>Cat</h1>");
            
            String catId = request.getParameter("cat-id");
            if (catId != null && catId.length() > 0) {
                Catdao catdao = new Catdao();
                Cat cat = catdao.getcat(catId);
                out.println("<p>" + cat + "<p>");
            } else out.println("<p>Erreur Cat sans Cat :(</p>");
            
            out.println("</body></html>");
        }
    }

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init Cat Servlet ok");
	}
}
