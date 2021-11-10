package com.add.ejercicio2;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class Ejercicio2 {
	public static void main(String[] args) {
		String basedatos = "aadu2";
	    String host = "localhost";
	    String port = "3306";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "root";
	    
		//Agregamos primero la dependecia de apache commons dbcp en el pom.xml
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(urlConnection);
		ds.setUsername(user);
		ds.setPassword(pwd);
 
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		try {
			ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}		
}
