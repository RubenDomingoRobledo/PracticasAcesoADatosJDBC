package com.add.ejercicio4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PatronDAOEjercicio {
	
	public static void main(String[] args) {
		try {
			Connection conn=Conexion.conectar();
			Statement stm= conn.createStatement();
			stm.execute("DROP TABLE IF EXISTS estudiantes");
			stm.execute("CREATE TABLE IF NOT EXISTS estudiantes ("
					+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
					+ "nombre varchar(50),"
					+ "apellido varchar(50),"
					+ "modulo varchar(50),"
					+ "PRIMARY KEY (id));");
			stm.close();
			System.out.println("Tabla creada\n");
			
			Estudiante e1 = new Estudiante(1, "Julia", "García", "DAM");
			Estudiante e2 = new Estudiante(2, "Javier", "Fuentes", "DAW");	
			Estudiante e3 = new Estudiante(3, "Julia", "Rodriguez", "ASIR");	
			Estudiante e4 = new Estudiante(4, "Jacobo", "Ruiz", "SMR");	
			Estudiante e5 = new Estudiante(5, "John", "Romero", "TAE");	
			
			Controlador controller = new Controlador();
			
			System.out.println("1. AÑADIR ESTUDIANTES");
			controller.insert(e1);
			controller.insert(e2);
			controller.insert(e3);
			controller.insert(e4);
			System.out.println("Estudiantes añadidos\n");
			
			System.out.println("2. MOSTRAR ESTUDIANTES");
			controller.findAll();
			
			System.out.println("\n3. ACTUALIZAR ESTUDIANTE");
			e2.setModulo("DAM");
			controller.update(e2);
			System.out.println("Estudiante actualizado\n");
			
			System.out.println("4. MOSTRAR ESTUDIANTE ACTUALIZADO");
			controller.findByName("Javier");
			
			System.out.println("\n5. BORRAR ESTUDIANTE");
			controller.deleteByID(2);
			System.out.println("Estudiante borrado\n");
			
			System.out.println("6. MOSTRAR ESTUDIANTES");
			controller.findAll();
			
			System.out.println("\n7. AÑADIR NUEVO ESTUDIANTE");
			controller.insert(e5);
			System.out.println("Estudiante añadido\n");
			
			System.out.println("8. MOSTAR ESTUDIANTE AÑADIDO");
			controller.read(5);
			
			System.out.println("\n9. BORRAR TODOS LOS ESTUDIANTES");
			controller.removeAll();
			System.out.println("Estudiantes borrados\n");
			
			System.out.println("10. MOSTRAR ESTUDIANTES");
			controller.findAll();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
