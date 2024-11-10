package com.oracle.app;

import java.sql.SQLException;

import com.oracle.dao.OracleDAO;

public class Oracle {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		OracleDAO oracleDAO = new OracleDAO();
		
		// oracleDAO.createTable();

		oracleDAO.deleteData(1);
		oracleDAO.deleteData(2);
		
		oracleDAO.insertData(1,"username1");
		oracleDAO.insertData(2,"username2");
		oracleDAO.selectData();

		oracleDAO.updateData(1, "username3");
		System.out.println();

		oracleDAO.selectData();
		oracleDAO.deleteData(1);
		
		System.out.println();
		oracleDAO.selectData();
		
	}

}
