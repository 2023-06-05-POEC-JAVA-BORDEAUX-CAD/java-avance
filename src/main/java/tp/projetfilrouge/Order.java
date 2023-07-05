package tp.projetfilrouge;

public class Order {
	Integer id;
	String typePresta;
	String designation;
	Integer clientId;
	Integer nbDays;
	Integer unitPrice;
	Integer state;

	// constructeur vide
	public Order() {
	}

	// Constructeur
	public Order(Integer id, String typePresta, String designation, Integer clientId, Integer nbDays, Integer unitPrice,
			Integer state) {
		this.typePresta = typePresta;
		this.designation = designation;
		this.clientId = clientId;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
	}

	// Getter
	public Integer getid() {
		return id;
	}
	
	public String gettypePrest() {
		return typePresta;
	}

	public String getdesignation() {
		return designation;
	}

	public Integer getclientId() {
		return clientId;
	}

	public Integer getnbDays() {
		return nbDays;
	}

	public Integer getunitPrice() {
		return unitPrice;
	}

	public Integer getstate() {
		return state;
	}

	// Setter
	public void setid(Integer id) {
	this.id = id;	
	}
	
	public void settypePresta(String typePresta) {
		this.typePresta = typePresta;
	}

	public void getdesignation(String designation) {
		this.designation = designation;
	}

	public void getclientId(Integer clientId) {
		this.clientId = clientId;
	}

	public void getnbDays(Integer nbDays) {
		this.nbDays = nbDays;
	}

	public void getunitPrice(Integer unitPrice) {
		this.nbDays = unitPrice;
	}

	public void getstate(Integer state) {
		this.state = state;
	}

}
