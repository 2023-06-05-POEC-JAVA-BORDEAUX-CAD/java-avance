package fr.maboite.exercice;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.maboite.MonBean;

public class JsonMaker {

	/**
	 * Doit afficher sur la console la version JSON de getList()
	 * 
	 * @param args
	 * @throws JsonProcessingException
	 */
	public static void main(String[] args) throws JsonProcessingException {
		JsonMaker jsonMaker = new JsonMaker();
		String json = new ObjectMapper().writeValueAsString(jsonMaker.getList());
		System.out.println(json);
	
		while(true) {
			System.out.println(10 / jsonMaker.getNumber());
		}
	}

	public List<MonBean> getList() {

		ArrayList<MonBean> list = new ArrayList<>();

		MonBean monBean2 = new MonBean();
		monBean2.setNom("coucou");
		list.add(monBean2);

		MonBean monBean4 = new MonBean();
		monBean4.setId(3l);
		monBean4.setPrix(14);
		list.add(monBean4);

		return list;

	}
	
	
	/**
	 * Renvoie un nombre entre un et 10
	 * @return
	 */
	private int getNumber() {
		//
		int i = 0;
		while(i < 12) {
			i++;
		}
		System.out.println("lkjklj");
		
		return (int) (Math.random() * 10) + 1;
	}

}
