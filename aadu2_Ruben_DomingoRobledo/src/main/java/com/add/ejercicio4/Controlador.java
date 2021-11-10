package com.add.ejercicio4;

import java.util.ArrayList;
import java.util.List;
 
public class Controlador {
	
	private Vista vista= new Vista();
	
	public Controlador() {
	}

	public void insert(Estudiante estudiante ) {
		EstudianteDAO dao= new EstudianteDAO_();
		dao.insert(estudiante);
	}
	
	public void update(Estudiante estudiante) {
		EstudianteDAO dao= new EstudianteDAO_();
		dao.update(estudiante);
	}
	
	public void deleteByID(Integer id) {
		EstudianteDAO dao= new EstudianteDAO_();
		dao.deleteById(id);
	}
	
	public void read(Integer id) {
		EstudianteDAO dao= new EstudianteDAO_();
		vista.verEstudiante(dao.read(id));
	}
	
	public void findAll(){
		List<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
		EstudianteDAO dao= new EstudianteDAO_();
		listaEstudiantes=dao.findAll();
		vista.verEstudiantes(listaEstudiantes);
	}
	
	public void findByName(String name){
		List<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
		EstudianteDAO dao= new EstudianteDAO_();
		listaEstudiantes=dao.findByName(name);
		vista.verEstudiantes(listaEstudiantes);
	}
	
	public void removeAll() {
		EstudianteDAO dao= new EstudianteDAO_();
		dao.removeAll();
	}
	
}
