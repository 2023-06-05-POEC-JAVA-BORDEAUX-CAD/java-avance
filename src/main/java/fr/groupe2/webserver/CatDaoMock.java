package fr.groupe2.webserver;
import fr.groupe2.webserver.AppServlet;
import jakarta.ejb.Stateless;


@Stateless
public class CatDaoMock implements CatDaoInterface{
	
	@Override
		public Cat getPojo(Integer id) {
		return new Cat();
	}

	@Override
	public Cat getCat(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}




	
