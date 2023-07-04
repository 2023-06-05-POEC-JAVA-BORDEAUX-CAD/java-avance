package fr.groupe2.webserver;

import fr.group2.webserver.Cat;
import fr.group2.webserver.ICatService;

public class CatServiceMock implements ICatService{

	@Override
	public Cat getCat(Integer id) {
		// TODO Auto-generated method stub
		return new Cat(1,"mock");
	}

}
