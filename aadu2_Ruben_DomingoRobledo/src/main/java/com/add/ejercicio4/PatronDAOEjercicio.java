package com.add.ejercicio4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("Tabla creada");
			
			
			EstudianteDAO estudiante = new EstudianteDAO_();
			Estudiante e1 = new Estudiante(1, "Julia", "García", "DAM");
			Estudiante e2 = new Estudiante(2, "Javier", "Fuentes", "DAW");
			Estudiante e3 = new Estudiante(3, "Julia", "Rodríguez", "ASIR");
			Estudiante e4 = new Estudiante(4, "Jacobo", "Ruiz", "ASMR");
			
			estudiante.insert(e1);
			estudiante.insert(e2);
			estudiante.insert(e3);
			estudiante.insert(e4);
			System.out.println("Estudiantes insertados");
			
			List<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
			listaEstudiantes.add(e1);
			listaEstudiantes.add(e2);
			listaEstudiantes.add(e3);
			listaEstudiantes.add(e4);
			
			estudiante.update(e1);
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
