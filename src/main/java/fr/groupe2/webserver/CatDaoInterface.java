package fr.groupe2.webserver;
import fr.groupe2.webserver.AppServlet;

public interface CatDaoInterface {
	Cat getPojo(Integer id);

	Cat getCat(Integer id);

}
