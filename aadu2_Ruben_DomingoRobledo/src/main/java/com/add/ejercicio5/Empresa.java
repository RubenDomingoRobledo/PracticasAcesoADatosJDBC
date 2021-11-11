package com.add.ejercicio5;

public class Empresa {
	private int id;
	private String nombre;
	private String descripcion;
	private String pais;
	private int cantidadEmpleados;
	
	public Empresa(int id, String nombre, String descripcion, String pais, int cantidadEmpleados) {
		super();
		this.id=id;
		this.nombre=nombre;
		this.descripcion= descripcion;
		this.pais=pais;
		this.cantidadEmpleados= cantidadEmpleados;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Empresa id= " + id + ", nombre= " + nombre + ", descripcion= " + descripcion + ", pais= " + pais;
	}

	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}
}
