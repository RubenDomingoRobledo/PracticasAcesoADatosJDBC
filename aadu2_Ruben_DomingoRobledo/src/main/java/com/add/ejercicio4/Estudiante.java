package com.add.ejercicio4;

public class Estudiante {
	private int id;
	private String nombre;
	private String apellido;
	private String modulo;
	
	public Estudiante() {
		super();
	}
	
	public Estudiante(int id, String nombre, String apellido, String modulo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.modulo = modulo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
}
