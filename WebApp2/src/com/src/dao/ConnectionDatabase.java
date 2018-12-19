/**
 * 
 */
package com.src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Akash Hande
 *
 */
public class ConnectionDatabase {
	public static Connection connect;
	
	private String host = "localhost";
	private String db = "sql_injection";  
	private String driver = "com.mysql.jdbc.Driver";  
	private String user = "root";
	private String pass = "root";
	
	public Connection connectToDB(){
		try{
            String url ="jdbc:mysql://"+host+":3306/"+db;

            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", pass);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");
            
			Class.forName(driver);
			connect = DriverManager.getConnection(url, user, pass);
			System.out.println("Connecting succesfully");
		}catch(Exception exp){
			System.out.println("Problem :: "+exp);
			System.out.println("Cannot connect to database server");
		}
		return connect;
	}
}
