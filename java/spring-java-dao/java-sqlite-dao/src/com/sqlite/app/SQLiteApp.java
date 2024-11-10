package com.sqlite.app;

import java.sql.SQLException;

import com.sqlite.dao.SQLiteDAO;

public class SQLiteApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		SQLiteDAO sql = new SQLiteDAO();
		
		// sql.sqlCreate();		
		
		sql.sqlDelete(1);
		sql.sqlDelete(2);
		
		sql.sqlInsert(1,"username1");
		sql.sqlInsert(2,"username2");
		
		sql.sqlSelect();
		
		sql.sqlUpdate(1, "username3");
		
		System.out.println();
		
		sql.sqlSelect();
		sql.sqlDelete(1);
		
		System.out.println();
		
		sql.sqlSelect();
	}

}
