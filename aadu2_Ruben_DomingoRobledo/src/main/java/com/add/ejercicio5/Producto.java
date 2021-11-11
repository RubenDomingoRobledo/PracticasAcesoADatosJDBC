package com.add.ejercicio5;

public class Producto extends Empresa {
	private int id;
	private String nombre;
	private double precio;
	private boolean artesanal;
	
	public Producto() {
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public boolean isArtesanal() {
		return artesanal;
	}
	public void setArtesanal(boolean artesanal) {
		this.artesanal = artesanal;
	}

	@Override
	public String toString() {
		return "Producto id= " + id + ", nombre= " + nombre + ", precio= " + precio + ", artesanal= " + artesanal;
	}
}
