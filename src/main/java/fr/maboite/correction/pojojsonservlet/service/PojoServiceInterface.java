package fr.maboite.correction.pojojsonservlet.service;

import fr.maboite.correction.pojojsonservlet.pojo.Pojo;

public interface PojoServiceInterface {

	void save(Pojo pojo);

	Pojo get(Integer id);

}