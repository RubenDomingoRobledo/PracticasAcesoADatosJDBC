package com.add.ejercicio4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO_ implements EstudianteDAO{
	
	public void insert(Estudiante estudiante) {
		try {			
			Connection conn=Conexion.conectar();
			Statement stm= conn.createStatement();
			stm.execute("INSERT INTO estudiantes values ('"+estudiante.getId()+"','"+estudiante.getNombre()+"','"+estudiante.getApellido()+"','"+estudiante.getModulo()+"')");
			stm.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean update(Estudiante estudiante) {
		boolean update=false;		
		try {
			Connection conn=Conexion.conectar();
			Statement stm=conn.createStatement();
			stm.execute("UPDATE estudiantes SET nombre='"+estudiante.getNombre()+"', apellido='"+estudiante.getApellido()+"', modulo='"+estudiante.getModulo()+"'" +" WHERE ID="+estudiante.getId());
			update=true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return update;
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean eliminar=false;	
		try {
			Connection conn=Conexion.conectar();
			Statement stm=conn.createStatement();
			stm.execute("DELETE FROM estudiantes WHERE ID= "+ id);
			eliminar=true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return eliminar;
	}

	@Override
	public List<Estudiante> findAll() {
		List<Estudiante> listaEstudiantes= new ArrayList<Estudiante>();
		try {
			Connection conn=Conexion.conectar();
			Statement stm=conn.createStatement();
			ResultSet rs= stm.executeQuery("SELECT * FROM estudiantes");
			while (rs.next()) {
				Estudiante e=new Estudiante();
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido(rs.getString(3));
				e.setApellido(rs.getString(4));
				listaEstudiantes.add(e);
			}
			stm.close();
			rs.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return listaEstudiantes;
	}

	@Override
	public List<Estudiante> findByName(String name) {
		List<Estudiante> listaEstudiantes= new ArrayList<Estudiante>();
		try {
			Connection conn=Conexion.conectar();
			Statement stm=conn.createStatement();
			ResultSet rs= stm.executeQuery("SELECT * FROM estudiantes WHERE nombre ='"+name+"'");
			while (rs.next()) {
				Estudiante e=new Estudiante();
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido(rs.getString(3));
				e.setApellido(rs.getString(4));
				listaEstudiantes.add(e);
			}
			stm.close();
			rs.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return listaEstudiantes;
	}

	@Override
	public boolean removeAll() {	
		boolean eliminar=false;
		try {
			Connection conn=Conexion.conectar();
			Statement stm=conn.createStatement();
			stm.execute("DELETE FROM estudiantes");
			eliminar=true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return eliminar;
	}
}
