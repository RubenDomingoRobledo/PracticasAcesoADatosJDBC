package com.add.ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PatronDAOEjercicio {
	public static void main(String[] args) {
		String basedatos = "aadu2";
	    String host = "localhost";
	    String port = "3306";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "Alcobendas99*";

	    try {
	            Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
	            Statement stmnt = conn.createStatement();
	            stmnt.execute("DROP TABLE IF EXISTS estudiantes");   
			    stmnt.execute("CREATE TABLE IF NOT EXISTS aadu2.estudiantes ("
			    		+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
			    		+ "nombre varchar(50),"
			    		+ "apellido varchar(50),"
			    		+ "modulo varchar(50),"
			    		+ "PRIMARY KEY (id));");
	    }	 
	    catch (SQLException e) {
	    	e.printStackTrace();
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
