package com.zsgs.careplus.repository.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/careplus";
	private static final String USER = "root";
	private static final String PASSWORD = "2002";
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
