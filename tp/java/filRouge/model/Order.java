package filRouge.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="orders")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "type_presta")
	private String typePresta;
	@Column(name = "designation")
	private String designation;
	@ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "client_id")
	private Client client;
	@Column(name = "nb_days")
	private int nbDays;
	@Column(name = "unit_price")
	private int unitPrice;
	@Column(name = "state")
	private int state;
	
	
	@ManyToMany
	@JoinTable(name = "assignedProduct_order", joinColumns = @JoinColumn(name = "id", nullable = true), inverseJoinColumns = @JoinColumn(name = "product_id"))
private List<Product> productList;
	public Order() {
		super();
	}



	public Order(String typePresta, String designation, Client client, int nbDays, int unitPrice, int state) {
		super();
		this.typePresta = typePresta;
		this.designation = designation;
		this.client = client;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypePresta() {
		return typePresta;
	}

	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Client getClientId() {
		return client;
	}

	public void setClientId(Client client) {
		this.client = client;
	}

	public int getNbDays() {
		return nbDays;
	}

	public void setNbDays(int nbDays) {
		this.nbDays = nbDays;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}

