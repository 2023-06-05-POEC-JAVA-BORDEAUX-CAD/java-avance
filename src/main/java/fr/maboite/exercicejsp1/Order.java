package fr.maboite.exercicejsp1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
		
	@Column(name="type_presta")
	private String type_presta;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="client_id")
	private int client_id;
	
	@Column(name="nb_days")
	private int nb_days;
	
	@Column(name="unit_price")
	private int unit_price;
	
	@Column(name="state")
	private byte state;
	
	// Getter & Setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getType_presta() {
		return type_presta;
	}

	public void setType_presta(String type_presta) {
		this.type_presta = type_presta;
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	
	public int getNb_days() {
		return nb_days;
	}

	public void setNb_days(int nb_days) {
		this.nb_days = nb_days;
	}
	
	public int getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	
	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}
	
	public void onLoad() {
		System.out.println("Message 1");   
		System.out.println("Message 2" + loadId); 
	
	}
	
}
