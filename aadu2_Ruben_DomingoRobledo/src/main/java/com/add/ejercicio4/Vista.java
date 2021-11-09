package com.add.ejercicio4;

import java.util.List;
 
public class Vista {
	public void verEstudiante(Estudiante estudiante) {
		System.out.println("Datos del Estudiante: "+estudiante);
	}
	
	public void verClientes(List<Estudiante> estudiantes) {
		for (Estudiante estudiante : estudiantes) {
			System.out.println("Datos del Estudiante: "+estudiante);
		}		
	}
}