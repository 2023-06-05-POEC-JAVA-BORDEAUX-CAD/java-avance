package fr.maboite.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Welcome", displayName = "Welcome Servlet", urlPatterns = "/welcome2", loadOnStartup = 1)
public class ExoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>OUAIS C'EST MOI LE BEST BRO QU'EST-CE TU VAS FAIRE</title></head><body>");
            out.println("<h2>ALEXIS POWERED EXERCICE</h2>");
            out.println("</body></html>");
        }
    }
}
