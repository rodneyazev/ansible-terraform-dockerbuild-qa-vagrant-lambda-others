// Create, Insert, Update, Delete PostgreSQL data

package com.postgresql.app;

import java.sql.SQLException;

import com.postgresql.dao.PostgreSQLDAO;

public class PostgreSQL {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO();
		
		// postgreSQLDAO.createTable();
		
		postgreSQLDAO.deleteData(1);
		postgreSQLDAO.deleteData(2);
		
		postgreSQLDAO.insertData(1,"username1");
		postgreSQLDAO.insertData(2,"username2");
		postgreSQLDAO.selectData();

		postgreSQLDAO.updateData(1, "username3");
		System.out.println();
		postgreSQLDAO.selectData();

		postgreSQLDAO.deleteData(1);
		System.out.println();
		
		postgreSQLDAO.selectData();
	}

}
