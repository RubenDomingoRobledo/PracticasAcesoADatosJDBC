package com.add.ejercicio5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.add.ejercicio4.Conexion;

public class MenuOpciones {
	public static void main(String[] args) {
		Connection conn=Conexion.conectar();
		
		Producto p1 = new Producto (1, "Pan", 0.99, "Pan artesano recien hecho");
		Producto p2 = new Producto (2, "Rosquillas", 2.99, "Rosquillas hechas con cariño");
		Producto p3 = new Producto (3, "Palmeras", 3.99, "Palmeras de chocolate");
		Producto p4 = new Producto (4, "Churros", 4.99, "Churros o porras");
		Empresa e1 = new Empresa(1, "Panaderías Paco", "Famosa en el mundo entero", "España", 15000);
		
		System.out.println("1. SENTENCIAS DDL ");
		System.out.println("2. CRUD ");
		System.out.println("3. BORRAR DATOS ALMACENADOS ");
		System.out.println("Introduzca una opción: ");
		
		Scanner sc= new Scanner(System.in);
		int opcion= sc.nextInt();
		
		if (opcion == 1) {
			System.out.println("1. CREATE TABLE");
			System.out.println("2. ALTER TABLE");
			System.out.println("3. DROP TABLE");
			System.out.println("Introduzca una opción: ");
			
			int opcion2= sc.nextInt();
			switch(opcion2) {
			case 1:
				try {
					Statement stm= conn.createStatement();
					stm.execute("CREATE TABLE producto ("
							+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
							+ "nombre varchar(50),"
							+ "precio decimal (7,2),"
							+ "PRIMARY KEY (id))");
					System.out.println("Tabla producto creada");
					
					stm.execute("CREATE TABLE empresa ("
							+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
							+ "nombre varchar(50),"
							+ "descripcion varchar (100),"
							+ "pais varchar(50),"
							+ "PRIMARY KEY (id))");
					System.out.println("Tabla empresa creada");
					stm.close();
				} 
				catch (SQLException e) {
					System.out.println("La tabla/s ya existe");				
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
					System.out.println("La tabla ya contiene dichos datos");;
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
						System.out.println("No existe la tabla producto");
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
						System.out.println("No existe la tabla empresa");
					}
					break;
				}
			}
		}
			
		else if (opcion == 2) {
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
					stm.execute("INSERT INTO producto values ('"+p1.getId()+"','"+p1.getNombre()+"','"+p1.getPrecio()+"','"+p1.getDescripcion()+"'),"
							+ "('"+p2.getId()+"','"+p2.getNombre()+"','"+p2.getPrecio()+"','"+p2.getDescripcion()+"'),"
							+ "('"+p3.getId()+"','"+p3.getNombre()+"','"+p3.getPrecio()+"','"+p3.getDescripcion()+"'),"
							+ "('"+p4.getId()+"','"+p4.getNombre()+"','"+p4.getPrecio()+"','"+p4.getDescripcion()+"')");
					
					System.out.println("Datos de producto insertados");
					
					stm.execute("INSERT INTO empresa values ('"+e1.getId()+"','"+e1.getNombre()+"','"+e1.getDescripcion()+"','"+e1.getPais()+"','"+e1.getCantidadEmpleados()+"')");
					System.out.println("Datos de empresa insertados");
					stm.close();
				} 
				catch (SQLException e) {
					System.out.println("Los datos ya estan insertados anteriormente");
				}
			break;
			
			case 2:
				try {
					List<Producto> listaProductos= new ArrayList<Producto>();
					Statement stm=conn.createStatement();
					ResultSet rs= stm.executeQuery("SELECT * FROM producto");
					while (rs.next()) {
						Producto producto =new Producto();
						producto.setId(rs.getInt("id"));
						producto.setNombre(rs.getString("nombre"));
						producto.setPrecio(rs.getDouble("precio"));
						producto.setDescripcion(rs.getString("descripcion"));
						listaProductos.add(producto);
						System.out.println("Datos del producto: "+ producto);
					}
					rs.close();
					stm.close();
				}
				catch (SQLException e) {
					System.out.println("No se pueden mostrar los datos de producto");
				}
				
				try {
					Empresa empresa =new Empresa();
					Statement stm=conn.createStatement();
					ResultSet rs= stm.executeQuery("SELECT * FROM empresa");
					while (rs.next()) {
						empresa.setId(rs.getInt("id"));
						empresa.setNombre(rs.getString("nombre"));
						empresa.setDescripcion(rs.getString("descripcion"));
						empresa.setPais(rs.getString("pais"));
						empresa.setCantidadEmpleados(rs.getInt("cantidadEmpleados"));
						System.out.println("\nDatos de la empresa: "+ empresa);
					}
					rs.close();
					stm.close();
				}
				catch (SQLException e) {
					System.out.println("No se pueden mostrar los datos de empresa");
				}
				break;
				
			case 3:
				System.out.println("1. MODIFICAR PRODUCTO");
				System.out.println("2. MODIFICAR EMPRESA");
				System.out.println("Introduzca una opción: ");
				int opcion5= sc.nextInt();
				
				switch (opcion5) {
				case 1:
					System.out.println("¿Qué producto deseas modificar?");
					System.out.println("Producto 1 ------1");
					System.out.println("Producto 2 ------2");		
					System.out.println("Producto 3 ------3");
					System.out.println("Producto 4 ------4");
					System.out.println("Introduzca una opción: ");
					int opcion6= sc.nextInt();
					switch (opcion6) {
					case 1:
						try {
							System.out.println("Introduzca un nombre: ");
							String n= sc.nextLine();
							
							System.out.println("Introduzca un precio: ");
							Double p= sc.nextDouble();
							
							System.out.println("Introduzca una descripcion: ");
							String desc= sc.nextLine();
							
							PreparedStatement ps = conn.prepareStatement("UPDATE producto SET nombre = ?, precio = ?, descripcion = ?" + "WHERE id = 1");
							ps.setString(1, n);
							ps.setDouble(2, p);
							ps.setString(3, desc);

							ps.executeUpdate();  
							System.out.println("Producto modificado");
							break;
						} 
						catch (SQLException e) {
							System.out.println("El producto 1 no se ha podido modificar");
						}
						
					case 2:
						try {
							System.out.println("Introduzca un nombre: ");
							String nombre= sc.nextLine();
							
							System.out.println("Introduzca un precio: ");
							Double precio= sc.nextDouble();
							
							System.out.println("Introduzca una descripcion: ");
							String descripcion= sc.nextLine();
							
							PreparedStatement ps = conn.prepareStatement("UPDATE producto SET nombre = ?, precio = ?, descripcion = ?" + "WHERE id = 2");
							ps.setString(1, nombre);
							ps.setDouble(2, precio);
							ps.setString(3, descripcion);

							ps.executeUpdate();  
							System.out.println("Producto modificado");
							break;
						} 
						catch (SQLException e) {
							System.out.println("El producto 2 no se ha podido modificar");
						}
						
					case 3:
						try {
							System.out.println("Introduzca un nombre: ");
							String n= sc.nextLine();
							
							System.out.println("Introduzca un precio: ");
							Double p= sc.nextDouble();
							
							System.out.println("Introduzca una descripcion: ");
							String desc= sc.nextLine();
							
							PreparedStatement ps = conn.prepareStatement("UPDATE producto SET nombre = ?, precio = ?, descripcion = ?" + "WHERE id = 3");
							ps.setString(1, n);
							ps.setDouble(2, p);
							ps.setString(3, desc);

							ps.executeUpdate();  
							System.out.println("Producto modificado");
							break;
						} 
						catch (SQLException e) {
							System.out.println("El producto 3 no se ha podido modificar");
						}
						
					case 4:
						try {
							System.out.println("Introduzca un nombre: ");
							String nombre= sc.nextLine();
							
							System.out.println("Introduzca un precio: ");
							Double precio= sc.nextDouble();
							
							System.out.println("Introduzca una descripcion: ");
							String descripcion= sc.nextLine();
							
							PreparedStatement ps = conn.prepareStatement("UPDATE producto SET nombre = ?, precio = ?, descripcion = ?" + "WHERE id = 4");
							ps.setString(1, nombre);
							ps.setDouble(2, precio);
							ps.setString(3, descripcion);

							ps.executeUpdate();  
							System.out.println("Producto modificado");
							break;
						} 
						catch (SQLException e) {
							System.out.println("El producto 4 no se ha podido modificar");
						}
						
					default:
						break;
					}
				case 2:
					try {
						System.out.println("Introduzca un nombre: ");
						String nombre= sc.nextLine();
						
						System.out.println("Introduzca uns descripcion: ");
						String descripcion= sc.nextLine();
						
						System.out.println("Introduzca un pais: ");
						String pais= sc.nextLine();
						
						System.out.println("Introduzca una cantidad de empleados: ");
						int cantidadEmpleados= sc.nextInt();
						
						PreparedStatement ps = conn.prepareStatement("UPDATE empresa SET nombre = ?, descripcion = ?, pais = ?, cantidadEmpleados = ?" + "WHERE id = 1");
						ps.setString(1, nombre);
						ps.setString(2, descripcion);
						ps.setString(3, pais);
						ps.setInt(4, cantidadEmpleados);

						ps.executeUpdate();  
						System.out.println("Empresa modificada");
						break;
					} 
					catch (SQLException e) {
						System.out.println("La empresa no se ha podido modificar");
					}
					
				default:
					break;
				}
			}	
		sc.close();
		}
	}
}
