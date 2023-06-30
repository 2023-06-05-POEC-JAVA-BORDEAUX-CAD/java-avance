package fr.TP_Pojo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Pojo", displayName="Pojo Servlet", urlPatterns = "/pojo", loadOnStartup = 1)
public class PojoServlet extends HttpServlet {

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
                    + "<h2>Quelle belle page générée dynamiquement !!!</h2>");
            
            String id = request.getParameter("id");
            Integer id_pojo = Integer.parseInt("id");
            if (id_pojo != null) {
                Pojo pojo = new Pojo();
                pojo.setId(id_pojo);
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