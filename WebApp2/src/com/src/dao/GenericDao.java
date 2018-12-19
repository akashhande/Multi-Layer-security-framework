package com.src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.src.dao.ConnectionDatabase;

public class GenericDao {
	
	private static PreparedStatement statement;
	private static ResultSet resultSet;
	public static Connection connect;
	
	public Map<String, ArrayList<String>> checkEntry(String user, String password) {
		Map<String, ArrayList<String>> output = new HashMap<String, ArrayList<String>>();
		ArrayList<String> query = new ArrayList<String>();
		ArrayList<String> iduser_info = new ArrayList<String>();
		ArrayList<String> user_name = new ArrayList<String>();
		ArrayList<String> user_password = new ArrayList<String>();
		ArrayList<String> first_name = new ArrayList<String>();
		ArrayList<String> last_name = new ArrayList<String>();
		ArrayList<String> phone_number = new ArrayList<String>();
		ArrayList<String> exception = new ArrayList<String>();
		ConnectionDatabase cDB = new ConnectionDatabase();
		try {
        	    connect = cDB.connectToDB();
        	    String sql = "SELECT iduser_info, user_name, user_password, first_name, last_name, phone_number FROM user_information WHERE user_name='"+user+ "'" + " AND user_password='"+password+"'";
        	    statement = connect.prepareStatement(sql); 
    			resultSet = statement.executeQuery();
    				while(resultSet.next()){
    					iduser_info.add(""+resultSet.getInt("iduser_info"));
    					user_name.add(resultSet.getString("user_name"));
    					user_password.add(resultSet.getString("user_password"));
    					first_name.add(resultSet.getString("first_name"));
    					last_name.add(resultSet.getString("last_name"));
    					phone_number.add(resultSet.getString("phone_number"));
					} 
    				query.add(sql);
    			output.put("query", query);
				output.put("iduser_info", iduser_info);
				output.put("user_name", user_name);
				output.put("user_password", user_password);
				output.put("first_name", first_name);
				output.put("last_name", last_name);
				output.put("phone_number", phone_number);
	      } catch (Exception exp) { 
	    	  System.out.println("Problem :: "+exp);
			  System.out.println("----- Problem in GenericDao checkEntry() -----");
			  exception.add(exp.toString());
			  output.put("exception", exception);
	      } finally{ 
	    	  try {
				if(resultSet != null){
					resultSet.close();
					}
				if(statement != null){
					statement.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return output; 
	}
}
