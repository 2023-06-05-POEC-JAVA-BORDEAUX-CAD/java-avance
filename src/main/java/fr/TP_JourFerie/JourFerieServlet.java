package fr.TP_JourFerie;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "JourFerie", displayName = "JourFerie Servlet", urlPatterns = "/jour-ferie", loadOnStartup = 1)
public class JourFerieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private JourFerieService jourFerieService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jour = Integer.parseInt(request.getParameter("j"));
        int mois = Integer.parseInt(request.getParameter("m"));
        int annee = Integer.parseInt(request.getParameter("a")); 

        LocalDate date = LocalDate.of(annee, mois, jour);
        String message;

        if (jourFerieService.estJourFerie(date) || estWeekend(date)) {
            message = "C'est le week-end !";
        } else {
            message = "C'est jour travaillé.";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>" + message + "</h2>");
        out.println("</body></html>");
    }

    private boolean estWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}