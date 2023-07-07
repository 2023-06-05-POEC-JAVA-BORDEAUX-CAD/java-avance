package fr.nicolas.facebean.tpClient.DataBase;

import java.sql.SQLException;

import jakarta.ejb.Stateless;

import java.sql.*;

@Stateless
public class DataBaseManager {

	final String USE_DB="use messenger";
	final String PASSWORD="Ovbt9,yvzdMjollnir";
	final String LOGIN ="root";
	
	public DataBaseManager() {}
	
	
	public void insert(String sql) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", LOGIN, PASSWORD);
			 Statement stmt = conn.createStatement();
			 stmt.executeUpdate("use db");
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use db");
            res = stmt.executeQuery(sql);
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    
        return res;
	}
	
}
