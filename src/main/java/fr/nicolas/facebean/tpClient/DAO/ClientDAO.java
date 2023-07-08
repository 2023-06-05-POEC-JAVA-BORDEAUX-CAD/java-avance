package fr.nicolas.facebean.tpClient.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
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
	
	

	public List<Client> getClients() {

		List<Client> clients = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", LOGIN, PASSWORD);
			ResultSet res = dbm.getDatas("SELECT * FROM CLIENT", conn);
			if(!res.next()) {
				clients =null;
			} else {
				do {
					Client client = new Client();
	                client.setId(res.getInt("id"));
	                client.setFirstName(res.getString("first_name"));
	                client.setLastName(res.getString("last_name"));
	                client.setCompanyName(res.getString("company_name"));
	                clients.add(client);
				} while(res.next());
			}
			conn.close();
		} catch(SQLException e) {
			System.out.println("sql error in DAO layer : " + e.getMessage());
			clients = null;
		}catch(ClassNotFoundException e) {
			System.out.println("Error class not found error in DAO layer : " + e.getMessage());
		} catch(NullPointerException e) {
			System.out.println("Error null object in DAO layer : " + e.getMessage());
			clients = null;
		}
		
		return clients;
	}
	
	
	public Client getClientById(Integer id) {
//		return this.clients.get(id);
		Client client = new Client();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "Ovbt9,yvzdMjollnir");
			ResultSet res = dbm.getDatas("SELECT * FROM CLIENT WHERE id="+id+"", conn);
						
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
			System.out.println( "sql error in DAO layer : " + e.getMessage());
			client = null;
		} catch(ClassNotFoundException e) {
			System.out.println("Error class not found error in DAO layer : " + e.getMessage());
		} catch(NullPointerException e) {
			System.out.println("Error null object in DAO layer : " + e.getMessage());
			clients = null;
		}
		
		return client;
		
		
	}
	
	public void insertClient(Client client) {
		String sql = "INSERT INTO CLIENT (first_name, last_name, company_name)"
				+ "VALUES"
				+ "('"+ client.getFirstName() +"', '"+ client.getLastName() +"', '" + client.getCompanyName() +"')";
		dbm.insert(sql);
	}
	
	
}
