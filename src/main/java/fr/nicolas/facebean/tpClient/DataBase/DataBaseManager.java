package fr.nicolas.facebean.tpClient.DataBase;

import java.sql.SQLException;

import jakarta.ejb.Stateless;

import java.sql.*;

@Stateless
public class DataBaseManager {

	final String USE_DB="use clients";
	final String PASSWORD="Ovbt9,yvzdMjollnir";
	final String LOGIN ="root";
	
	public DataBaseManager() {}
	
	
	public void insert(String sql) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", LOGIN, PASSWORD);
			 Statement stmt = conn.createStatement();
			 stmt.executeUpdate(USE_DB);
			 stmt.executeUpdate(sql);
			 conn.close();
		} 
		catch(ClassNotFoundException | SQLException e)  {
			System.out.println(e);
		}
	}
	
	
	public ResultSet getDatas(String sql, Connection conn) {
		ResultSet res = null;
        
        try {
        	
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(USE_DB);
            res = stmt.executeQuery(sql);
        }
        catch (SQLException e){
            System.out.println("sql error in data base layer : " + e.getMessage());
            res = null;
        }
    
        return res;
	}
	
}
