package fr.maboite.exercice;

import java.util.ArrayList;
import java.util.List;

import org.jacoco.report.check.IViolationsOutput;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.maboite.MonBean;

public class JsonMaker {
	
	/**
	 * Doit afficher sur la console la version JSON de getList()
	 * @param args
	 * @throws JsonProcessingException 
	 */
	public static void main(String[] args) throws JsonProcessingException  {
		JsonMaker jsonMaker = new JsonMaker();
		String json = new ObjectMapper().writeValueAsString(jsonMaker.getList());
		System.out.println(json);
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