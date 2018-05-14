package com.pennat.prod.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtils {


	private DBUtils() {
	}

	public static Connection getConection() {
		Connection conn = null;
		String dbURL = "jdbc:sqlserver://192.168.1.145:1433;databaseName=training2018";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbURL, "pennant", "zxcvbn1@");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

}
