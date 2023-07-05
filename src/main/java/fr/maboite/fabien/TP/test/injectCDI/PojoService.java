package fr.maboite.fabien.TP.test.injectCDI;

import java.util.HashMap;

import jakarta.ejb.Stateless;

@Stateless
public class PojoService {

	private HashMap<Integer, Pojo> pojo;

//	public HashMap<Integer, Pojo> addPojo(int poPojo) {
//
//	}

	public Pojo getPojo(Integer id) {
		return pojo.get(id);
	}
}
