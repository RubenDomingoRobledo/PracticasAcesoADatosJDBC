package com.add.ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

public class Ejercicio3 {
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
	            stmnt.execute("DROP TABLE IF EXISTS usuarios");   
			    stmnt.execute("CREATE TABLE aadu2.usuarios("
			    		+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
			    		+ "nombre varchar(100),"
			    		+ "apellido varchar(100),"
			    		+ "mail varchar(100),"
			    		+ "PRIMARY KEY (id));");
			    
			    System.out.println("Tabla usuarios creada");
			    
	            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\rubir\\Downloads\\uusarios.csv"));
	            String line = null;
			    conn.setAutoCommit(false);
			    System.out.println("Comenzamos transaccion");
			    
	            PreparedStatement sInsert = conn.prepareStatement("INSERT INTO usuarios (nombre, apellido, mail) VALUES (?,?,?);"); 
	            while((line =  bf.readLine())!=null){
	                StringTokenizer st = new StringTokenizer(line, "|");
	                sInsert.setString(1, st.nextToken());
	                sInsert.setString(2, st.nextToken());
	                sInsert.setString(3, st.nextToken());
	                sInsert.executeUpdate();
	            }
	            conn.commit();
	            System.out.println("Datos insertados y transacción acabada"); 
	            bf.close();
	            conn.close();
	    } 
	    catch (SQLException e) {
	    	e.printStackTrace();
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
