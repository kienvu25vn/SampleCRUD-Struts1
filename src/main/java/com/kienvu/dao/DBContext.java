package com.kienvu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {



    public static Connection getConnection() throws Exception {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			return DriverManager.getConnection("jdbc:postgresql:struts1", "postgres", "123");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
