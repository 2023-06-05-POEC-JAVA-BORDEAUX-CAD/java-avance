package fr.maboite.servlet;
/* Cette ligne définit le package dans lequel se trouve la classe WelcomeServlet. 
 * Le code est organisé en packages pour structurer les classes en fonction de leur fonctionnalité ou de leur domaine.*/

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

												  /* Ces lignes sont des instructions d'importation qui permettent d'utiliser différentes classes et interfaces nécessaires pour la création de la servlet. 
												   * Ces classes et interfaces sont fournies par les API Servlet et JSP de Jakarta EE.*/

@WebServlet(name="Welcome", 
	displayName="Welcome Servlet", 
	urlPatterns = "/welcome", 
	loadOnStartup = 1)

												  /* Cette annotation @WebServlet est utilisée pour indiquer que la classe WelcomeServlet est une servlet qui sera gérée par le conteneur de servlets (ici tomcat). 
												   * Elle fournit des métadonnées pour configurer la servlet. 
												   * Dans cet exemple, la servlet est nommée "Welcome", 
												   * son nom d'affichage est "Welcome Servlet", 
												   * son URL de correspondance est "/welcome", 
												   * et elle sera chargée au démarrage du serveur avec une priorité de 1.*/

public class WelcomeServlet extends HttpServlet { // la classe WelcomeServlet définit une servlet qui génère une page HTML de bienvenue en réponse à une requête HTTP GET.
												  /* Cette ligne déclare la classe WelcomeServlet qui étend la classe abstraite HttpServlet. 
												   * Cela signifie que WelcomeServlet est une classe concrète qui implémente les fonctionnalités d'une servlet HTTP.*/	
	
	private static final long serialVersionUID = 1L;
	
												  /* Cette ligne déclare une constante de classe serialVersionUID qui est utilisée pour la sérialisation des objets. 
												   * Elle garantit la compatibilité des versions sérialisées de la classe lorsque des modifications sont apportées.*/
												  /* La sérialisation des objets est le processus de conversion d'un objet en une séquence d'octets, de manière à ce qu'il puisse être stocké dans un support de stockage persistant, 
												   * transféré via un réseau ou restauré ultérieurement pour reconstituer l'objet original. 
												   * La sérialisation est principalement utilisée dans le domaine de la persistance des données et de la communication entre les applications.*/

	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
												  /* Cette méthode doGet est une méthode de rappel (callback) fournie par la classe HttpServlet. 
												   * Elle est invoquée par le conteneur de servlets lorsque la servlet reçoit une requête HTTP GET. 
												   * Le conteneur passe les objets HttpServletRequest et HttpServletResponse qui représentent respectivement la requête entrante et la réponse sortante.*/	
													
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			System.out.println(headerNames.nextElement());
		}
												  /* Ces lignes permettent de récupérer et d'afficher tous les noms des en-têtes de la requête HTTP entrante. 
												   * La méthode getHeaderNames() de l'objet HttpServletRequest renvoie une énumération des noms des en-têtes de la requête. 
												   * La boucle while itère sur cette énumération et affiche chaque nom d'en-tête.*/

		
		/* Ces lignes permettent de générer la réponse HTTP à renvoyer au client. La méthode */
        response.setContentType("text/html"); // La méthode setContentType("text/html") définit le type de contenu de la réponse comme étant du texte HTML.
        response.setBufferSize(8192); // La méthode setBufferSize(8192) définit la taille du tampon de la réponse.
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Générée par une servlet</title></head>");
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<h2>Quelle belle page générée dynamiquement !!!</h2>");
        /* À l'aide de l'objet PrintWriter obtenu à partir de response.getWriter(), nous pouvons écrire du contenu HTML dans la réponse. 
         * Dans cet exemple, nous générons une page HTML simple avec un titre et un paragraphe.*/ 
          
            

            String username = request.getParameter("username");
            if (username != null && username.length() > 0) {
                out.println("Vous êtes : " + username);
            }
            out.println("</body></html>");
            /* Nous utilisons également request.getParameter("username") pour récupérer la valeur du paramètre "username" 
             * de la requête GET et l'afficher si elle est présente.*/ 
        }
    }

    @Override
    public String getServletInfo() {
        return "La première servlet .";
        /* Cette méthode getServletInfo est fournie par la classe HttpServlet et elle est utilisée pour obtenir des informations sur la servlet. 
         * Dans cet exemple, elle renvoie simplement une chaîne de caractères décrivant la servlet.*/
    }

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init terminé");
	 /* Cette méthode init est également fournie par la classe HttpServlet et elle est appelée par le conteneur de servlets lors de l'initialisation de la servlet. 
	  * Dans cet exemple, nous l'overrideons pour ajouter notre propre code. 
	  * Ici, nous appelons également la méthode init() de la superclasse pour exécuter le comportement d'initialisation par défaut, 
	  * puis nous affichons simplement "Init terminé" dans la console.*/
	}
    
    
}