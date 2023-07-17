package tp;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFormBean {
	private Integer id;
	private String companyName;

	public ClientFormBean(Integer id, String companyName) {
		super();
		this.id = id;
		this.companyName = companyName;
	}

	public ClientFormBean() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void onLoad() {
		System.out.println("J'ai bien reçu l'id : " + id);
	}

	public String save() {
		System.out.println("Nous avons bien reçu votre requête " + id);
		return null;
	}

}
