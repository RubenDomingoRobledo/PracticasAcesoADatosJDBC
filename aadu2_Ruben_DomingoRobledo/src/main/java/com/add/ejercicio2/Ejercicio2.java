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
	    
		//Agregamos primero las dependecias de Apache Commons DBCP, HikariCP y C3PO en el pom.xml
	    //Creamos pool de conexiones
	    
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(urlConnection);
		ds.setUsername(user);
		ds.setPassword(pwd);
 
		ds.setMinIdle(2);
		ds.setMaxIdle(5);
		try {
			ds.getConnection();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}		
}
