package com.sqlite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDAO {

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:application.db");
	}
	
	public void sqlCreate() {
		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();		
			statement.execute("CREATE TABLE APPLICATION(ID INTEGER, NOME VARCHAR(255))");
			System.out.println("Table created successfully");
		} catch (SQLException e) {e.printStackTrace();}
	} 
	
	public void sqlInsert(int id, String nome) {
		try {
			Connection connection = new SQLiteDAO().getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO APPLICATION(ID, NOME) VALUES(?,?)");
			statement.setInt(1, id);
			statement.setString(2, nome);
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public void sqlSelect() {
		try {
			Connection connection = new SQLiteDAO().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM APPLICATION");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				int id = resultset.getInt("id");
			    String nome = resultset.getString("nome");
			    System.out.println("ID: " + id + "\tNome: " + nome);
			}
			resultset.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public void sqlUpdate(int id, String nome) {
		try {
			Connection connection = new SQLiteDAO().getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE APPLICATION SET NOME=? WHERE ID=?");
			statement.setString(1, nome);
			statement.setInt(2, id);		
			statement.execute();
			
			statement.close();
			connection.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public void sqlDelete(int id) {
		try {
			Connection connection;
			connection = new SQLiteDAO().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM APPLICATION WHERE ID=?");
			statement.setInt(1, id);		
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
}