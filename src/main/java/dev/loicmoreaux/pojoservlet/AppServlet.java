package dev.loicmoreaux.pojoservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="Pojo", displayName="Pojo Servlet", urlPatterns = "/pojo", loadOnStartup = 1)
public class AppServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PojoDAO pojoDAO;
	
	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Hello Pojo !</title>"
                    + "<style>"
                    + "*{margin: 0; padding: 0;}"
                    + "body{background-color: #333; color: #fff;text-align:center;font-family:sans-serif;}"
                    + "h1{margin: auto; font-size: 50px;}"
                    + "</style>"
                    + "</head>");
            out.println("<body>");
            out.println("<h1>Pojo</h1>");
            
            String catId = request.getParameter("id");
            if (catId != null && catId.length() > 0) {
                Pojo cat = pojoDAO.getPojo(Integer.valueOf(catId));
                if(cat != null) {
                	PojoToJson catJson = new PojoToJson();
                    out.println("<p>" + catJson.toJson(cat) + "<p>");
                } else {
                	response.setStatus(404);
                	out.println("<p>Erreur 404 :(</p>");
                }
                
                
            } else out.println("<p>Entrez un id dans la barre d'adresse</p>");
            
            out.println("</body></html>");
        }
    }

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init Pojo Servlet ok");
	}
}
