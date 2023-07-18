package fr.groupe2.tpcrm.model;

public class Order2 {
	private Integer id;
	private String type_presta;
	private String designation;
	private Integer client_id;
	private Integer nb_days;
	private Integer unit_price;
	private Integer state;

	public Order2(Integer id, String type_presta, String designation, Integer client_id,Integer nb_days, Integer unit_price,
			Integer state) {
		super();
		this.id = id;
		this.type_presta = type_presta;
		this.designation = designation;
		this.client_id = client_id;
		this.nb_days = nb_days;
		this.unit_price = unit_price;
		this.state = state;
	}

	public Order2() {

	};

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

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public Integer getNb_days() {
		return nb_days;
	}

	public void setNb_days(Integer nb_days) {
		this.nb_days = nb_days;
	}

	public Integer getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Integer unit_price) {
		this.unit_price = unit_price;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	};

}
