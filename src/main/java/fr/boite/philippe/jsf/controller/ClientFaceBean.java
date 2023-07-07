package fr.boite.philippe.jsf.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {
	private String message = "ce message de philippe";
	private String name = "philippe";
	private int age = 42;
	private boolean active = true;
	private Integer count = 40;
	private LocalDate birthDate = LocalDate.of(1981, 05, 17);

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}
