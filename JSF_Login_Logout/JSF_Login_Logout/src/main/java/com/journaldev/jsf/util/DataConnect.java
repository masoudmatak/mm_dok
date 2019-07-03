package com.journaldev.jsf.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		/*	Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mm_dok", "mm_dok", "mm_dok");*/
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://dokmasoud2.cq2fbxux0zky.eu-west-2.rds.amazonaws.com:3306/dokmasoud", "dokmasoud", "dokmasoud");		
			
			
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}