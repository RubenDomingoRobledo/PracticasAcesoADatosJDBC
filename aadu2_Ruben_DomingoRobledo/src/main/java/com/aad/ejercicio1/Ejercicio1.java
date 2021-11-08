package com.aad.ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio1 {
	public static void main(String[] args) {
		try {
			//Agregamos primero la dependecia de la h2database en el pom.xml
			
			Class.forName("org.h2.Driver");
			Connection conn= DriverManager.getConnection("jdbc:h2:"+"./Database/AADU2"+"Ruben"+"Alcobendas99");
			Statement st = conn.createStatement();
			
			st.execute("DROP TABLE IF EXISTS estudiantes");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS estudiantes ("
					+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
					+ "nombre varchar(50),"
					+ "apellido varchar(50),"
					+ "modulo varchar(50),"
					+ "PRIMARY KEY (id));");
			System.out.println("Table created");
			
			st.executeUpdate("INSERT INTO estudiantes (nombre, apellido, modulo) "
					+ "VALUES ('Juan', 'Pérez', 'Ciencias de la Salud'),"
					+ "('Marta', 'López', 'Letras'),"
					+ "('Pepe', 'Hurtado', 'Ciencias Sociales');");
			System.out.println("Datos insertados");
			
			ResultSet rs1 = st.executeQuery("SELECT * FROM estudiantes");
				int i=1;
			      while (rs1.next()) {
			    	System.out.println("--------------------");
			        System.out.println("ID: "+ i++);        
			        System.out.println("Nombre: " + rs1.getString("nombre"));
			        System.out.println("Apellido: " + rs1.getString("apellido"));
			        System.out.println("Modulo: " + rs1.getString("modulo"));
			      } 
			
			 st.executeUpdate("UPDATE estudiantes SET nombre='Lara' WHERE id=2");
			 st.executeUpdate("UPDATE estudiantes SET modulo='Artes' WHERE id=3");
			 st.executeUpdate("DELETE FROM estudiantes WHERE id=1");
			 System.out.println("\nDatos modificados");
			 
			 ResultSet rs2 = st.executeQuery("SELECT * FROM estudiantes");
			 int j=1;
			 while (rs2.next()) {
			    	System.out.println("--------------------");
			        System.out.println("ID: "+ j++);        
			        System.out.println("Nombre: " + rs2.getString("nombre"));
			        System.out.println("Apellido: " + rs2.getString("apellido"));
			        System.out.println("Modulo: " + rs2.getString("modulo"));
			 }
			 conn.close();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
