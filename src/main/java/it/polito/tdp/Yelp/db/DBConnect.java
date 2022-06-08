package it.polito.tdp.Yelp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class DBConnect {

	static private HikariDataSource ds=null;
	static private String url = "jdbc:mysql://localhost:3306/yelp?";
	public static Connection getConnection() {
		
		if(ds==null) {// singleton ne creo solo uno
			//crea nuova ds
			ds=new HikariDataSource();
			ds.setJdbcUrl(url);
			ds.setUsername("root");
			ds.setPassword("gioele");
		}
		try {
			return ds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		/*
		String url = "jdbc:mysql://localhost:3306/yelp?user=root&password=gioele";
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn ;
		} catch (SQLException e) {
			System.out.println("ERRORE di connessione al database");
			e.printStackTrace();
			return null ;
		}
		*/
	}
}
