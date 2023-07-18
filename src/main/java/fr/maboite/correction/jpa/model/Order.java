package fr.maboite.correction.jpa.model;

import java.util.HashSet;
import java.util.Set;

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

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TYPE_PRESTA")
	private String typePresta;

	private String designation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

	@Column(name = "NB_DAYS")
	private Integer nbDays;

	@Column(name = "UNIT_PRICE")
	private Integer unitPrice;

	private Boolean state;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ORDER_PRODUCT", 
		joinColumns = @JoinColumn(name = "ORDER_ID"),
		inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private Set<Product> products = new HashSet<>();

	public Integer getNbDays() {
		return nbDays;
	}

	public void setNbDays(Integer nbDays) {
		this.nbDays = nbDays;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	/**
	 * Associe this à product. 
	 * Modifie les DEUX collections : celle de this
	 * et celle de product afin que les données soient les mêmes
	 * que l'on navigue de product vers this, ou de this vers product
	 * @param product
	 */
	public void associateWithProduct(Product product) {
		if(product == null) {
			return;
		}
		this.products.add(product);
		product.getOrder().add(this);
	}

}