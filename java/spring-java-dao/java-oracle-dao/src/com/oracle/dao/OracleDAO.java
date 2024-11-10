package com.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDAO {
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.142:1521:xe", "SYSTEM", "it.@#$");
	}
	
	public void createTable() {
		try {
			Connection connection;
			connection = this.getConnection();
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE ORACLETABLE(ID INTEGER, NAME VARCHAR(255))");
			System.out.println("Table created successfully");
			statement.close();
			connection.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public void insertData(int id, String name) {
		try {
			Connection connection = new OracleDAO().getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO ORACLETABLE (ID, NAME) VALUES(?,?)");
			statement.setInt(1, id);
			statement.setString(2, name);		
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public void selectData() {
		try {
			Connection connection = new OracleDAO().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM ORACLETABLE");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				int id = resultset.getInt("id");
			    String name = resultset.getString("name");
			    System.out.println("ID: " + id + "\tNome: " + name);
			}
			resultset.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public void updateData(int id, String nome) {
		try {
			Connection connection = new OracleDAO().getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE ORACLETABLE SET NAME=? WHERE ID=?");
			statement.setString(1, nome);
			statement.setInt(2, id);		
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public void deleteData(int id) {
		try {
			Connection connection = new OracleDAO().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM ORACLETABLE WHERE ID=?");
			statement.setInt(1, id);		
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public void dropTable() {
		try {
			Connection connection = new OracleDAO().getConnection();
			PreparedStatement statement = connection.prepareStatement("DROP TABLE ORACLETABLE;");
			statement.close();
			connection.close();
			System.out.println("Table dropped.");
		} catch (SQLException e) {e.printStackTrace();}
	}
}
