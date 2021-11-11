package com.add.ejercicio5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.add.ejercicio4.Conexion;

public class MenuOpciones {
	public static void main(String[] args) {
		Connection conn=Conexion.conectar();
		
		Producto p1 = new Producto (1, "Pan", 0.99, true, "Pan artesano recien hecho");
		Producto p2 = new Producto (2, "Rosquillas", 2.99, false, "Rosquillas hechas con cariño");
		Producto p3 = new Producto (3, "Palmeras", 3.99, false, "Palmeras de chocolate");
		Producto p4 = new Producto (4, "Churros", 4.99, true, "Churros o porras");
		Empresa e1 = new Empresa(1, "Panaderías Paco", "Famosa en el mundo entero", "España", 15000);
		
		System.out.println("1. SENTENCIAS DDL ");
		System.out.println("2. CRUD ");
		System.out.println("3. BORRAR DATOS ALMACENADOS ");
		System.out.println("Introduzca una opción: ");
		
		Scanner sc= new Scanner(System.in);
		int opcion= sc.nextInt();
		
		switch(opcion) {
		case 1:
			System.out.println("1. CREATE TABLE");
			System.out.println("2. ALTER TABLE");
			System.out.println("3. DROP TABLE");
			System.out.println("Introduzca una opción: ");
			
			int opcion2= sc.nextInt();
			switch(opcion2) {
			case 1:
				try {
					Statement stm= conn.createStatement();
					stm.execute("CREATE TABLE IF NOT EXISTS producto ("
							+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
							+ "nombre varchar(50),"
							+ "precio decimal (7,2),"
							+ "artesanal boolean NOT NULL,"
							+ "PRIMARY KEY (id))");
					System.out.println("Tabla producto creada");
					
					stm.execute("CREATE TABLE IF NOT EXISTS empresa ("
							+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
							+ "nombre varchar(50),"
							+ "descripcion varchar (100),"
							+ "pais varchar(50),"
							+ "PRIMARY KEY (id))");
					System.out.println("Tabla empresa creada");
					stm.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case 2:
				try {
					Statement stm= conn.createStatement();
					stm.execute("ALTER TABLE producto ADD COLUMN descripcion varchar (100)");
					System.out.println("Tabla producto modificada");
					
					stm.execute("ALTER TABLE empresa ADD COLUMN cantidadEmpleados mediumint");
					System.out.println("Tabla empresa modificada");
					stm.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("1. BORRAR TABLA PRODUCTO");
				System.out.println("2. BORRA TABLA EMPRESA");
				System.out.println("Introduzca una opción: ");
				int opcion3= sc.nextInt();
				
				switch(opcion3) {
				case 1:
					try {
						Statement stm = conn.createStatement();
						stm.execute("DROP TABLE producto");
						System.out.println("Tabla producto borrada");
						stm.close();
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}
					break;
					
				case 2:
					try {
						Statement stm = conn.createStatement();
						stm.execute("DROP TABLE empresa");
						System.out.println("Tabla empresa borrada");
						stm.close();
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}
					break;
					
				default:
					break;
				}
			default:
				break;
			}
			
		case 2:
			System.out.println("1. INSERTAR DATOS");
			System.out.println("2. LEER DATOS");
			System.out.println("3. ACTUALIZAR DATOS");
			System.out.println("4. BORRAR DATOS");
			System.out.println("Introduzca una opción: ");
			int opcion4= sc.nextInt();
			
			switch(opcion4) {
			case 1:
				try {
					Statement stm= conn.createStatement();
					stm.execute("INSERT INTO producto values ('"+p1.getId()+"','"+p1.getNombre()+"','"+p1.getPrecio()+"','"+p1.isArtesanal()+"','"+p1.getDescripcion()+"')"
							+ "('"+p2.getId()+"','"+p2.getNombre()+"','"+p2.getPrecio()+"','"+p2.isArtesanal()+"','"+p2.getDescripcion()+"')"
							+ "('"+p3.getId()+"','"+p3.getNombre()+"','"+p3.getPrecio()+"','"+p3.isArtesanal()+"','"+p3.getDescripcion()+"')"
							+ "('"+p4.getId()+"','"+p4.getNombre()+"','"+p4.getPrecio()+"','"+p4.isArtesanal()+"','"+p4.getDescripcion()+"')");
					
					System.out.println("");
					
					stm.execute("INSERT INTO empresa values ('"+e1.getId()+"','"+e1.getNombre()+"','"+e1.getDescripcion()+"','"+e1.getPais()+"')");
					stm.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			break;
			
			case 2:
			}
		}
	}
}
