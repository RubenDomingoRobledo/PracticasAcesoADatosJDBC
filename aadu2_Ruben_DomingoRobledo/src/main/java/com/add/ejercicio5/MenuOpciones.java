package com.add.ejercicio5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.add.ejercicio4.Conexion;

public class MenuOpciones {
	public static void main(String[] args) {
		Connection conn=Conexion.conectar();
		
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
							+ "artesanal char(2) NOT NULL,"
							+ "PRIMARY KEY (id),"
							+ "CONSTRAINT ck_artesanal CHECK (artesanal IN ('Si' OR 'N')))");
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
			
		}
	}
}
