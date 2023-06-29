package fr.maboite;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPrinter {
	public static void main(String[] args) throws JsonProcessingException {
		JsonPrinter jp = new JsonPrinter();
		List<MonBean> beans = new ArrayList<>();
		beans = jp.printJson();
		beans.forEach(System.out::println);
		String json = new ObjectMapper().writeValueAsString(beans);
		System.out.println(json);
	}
	
	public List<MonBean> printJson(){
		List<MonBean> beans = new ArrayList<>();
		
		MonBean bean1 = new MonBean();
		bean1.setNom("bean1");
		beans.add(bean1);
		MonBean bean2 = new MonBean();
		bean2.setNom("bean2");
		beans.add(bean2);
		
		MonBean bean3 = new MonBean();
		bean3.setNom("bean3");
		beans.add(bean3);
		
		
		return beans;
	}
}
