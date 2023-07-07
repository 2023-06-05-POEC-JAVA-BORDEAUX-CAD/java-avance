package fr.nicolas.facebean.tpClient.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import fr.nicolas.facebean.tpClient.DataBase.DataBaseManager;
import fr.nicolas.facebean.tpClient.Entity.Client;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientDAO {

	
	private Map<Integer, Client> clients = new HashMap<>();

	final String USE_DB="use clients";
	final String PASSWORD="Ovbt9,yvzdMjollnir";
	final String LOGIN ="root";

	@Inject
	private DataBaseManager dbm;
	
	
	public ClientDAO() {
		this.clients.put(1, new Client(1, "Nicolas", "Duquesne", "word company"));
		this.clients.put(2, new Client(1, "Albert", "Duquesne", "word company"));
		this.clients.put(3, new Client(2, "Luc", "Duquesne", "word company"));
		this.clients.put(4, new Client(3, "Marc", "Duquesne", "word company"));
	}

	
	
	public Map<Integer, Client> getClients() {
		
		return this.clients;

//		List<Client> clients = new ArrayList<>();
//		
//		try {
//			
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", LOGIN, PASSWORD);
//			ResultSet res = dbm.getDatas("SELECT * FROM ARTICLE", conn);
//			while(res.next()) {
//				Client client = new Client();
//                client.setId(res.getInt("id"));
//                client.setFirstName(res.getString("first_name"));
//                client.setLastName(res.getString("last_name"));
//                client.setCompanyName(res.getString("company_name"));
//                clients.add(client);
//            }
//		} catch(SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return clients;
	}
	
	
	public Client getClientById(Integer id) {
//		return this.clients.get(id);
		Client client = new Client();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "Ovbt9,yvzdMjollnir");
			ResultSet res = dbm.getDatas("SELECT * FROM client WHERE id="+id+"", conn);
						
			if (!res.next()) {
				client = null;
			} else {
				do {
					client.setId(res.getInt("id"));
	                client.setFirstName(res.getString("first_name"));
	                client.setLastName(res.getString("last_name"));
	                client.setCompanyName(res.getString("company_name"));
				} while(res.next());
			}
			conn.close();
		} catch(SQLException e) {
			System.out.println( "sql error" + " " + e.getMessage());
			client = null;
		} catch(ClassNotFoundException e) {
			System.out.println("Error class not found error" + " " + e.getMessage());
		}
		
		return client;
		
		
	}
	
	public void insertClient(Client client) {
		String sql = "INSERT INTO client (first_name, last_name, company_name)"
				+ "VALUES"
				+ "('"+ client.getFirstName() +"', '"+ client.getLastName() +"', '" + client.getCompanyName() +"')";
		dbm.insert(sql);
	}
	
	
}
