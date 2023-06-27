package fr.maboite.exercice;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.MonBean;

public class JsonMaker {
	
	/**
	 * Doit afficher sur la console la version JSON de getList()
	 * @param args
	 */
	public static void main(String[] args)  {
		JsonMaker jsonMaker = new JsonMaker();
	}
	
	public List<MonBean> getList(){
		
		ArrayList<MonBean> list = new ArrayList<>();
		
		MonBean monBean2 = new MonBean();
		monBean2.setId(1l);
		monBean2.setNom("Nom 1");
		monBean2.setPrix(13);
		list.add(monBean2);

		MonBean monBean4 = new MonBean();
		monBean4.setId(4l);
		monBean4.setNom("Nom 4");
		monBean4.setPrix(14);
		list.add(monBean4);
		
		return list;
		
		
	}

}
