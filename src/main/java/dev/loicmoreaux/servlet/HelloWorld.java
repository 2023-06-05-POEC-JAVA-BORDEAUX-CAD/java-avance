package dev.loicmoreaux.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Hello", displayName="HelloWorld Servlet", urlPatterns = "/hello", loadOnStartup = 1)
public class HelloWorld extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Hello World !</title>"
                    + "<style>"
                    + "*{margin: 0; padding: 0;}"
                    + "body{background-color: #333; color: #fff;text-align:center;font-family:sans-serif;height:100vh;display: flex;}"
                    + "h1{margin: auto; font-size: 50px;}"
                    + "</style>"
                    + "</head>");
            out.println("<body>");
            
            String username = request.getParameter("username");
            if (username != null && username.length() > 0) {
                out.println("<h1>Hello "+ username + " !</h1>");
            } else out.println("<h1>Hello world !</h1>");
            
            out.println("</body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "La première serviette.";

    }

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inititialisation ok");
	}
 

}
