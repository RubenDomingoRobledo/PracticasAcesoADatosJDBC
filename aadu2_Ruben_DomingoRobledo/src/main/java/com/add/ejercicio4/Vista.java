package com.add.ejercicio4;

import java.util.List;
 
public class Vista {
	public void verEstudiante(Estudiante estudiante) {
		System.out.println("Datos del Estudiante: "+estudiante);
	}
	
	public void verEstudiantes(List<Estudiante> listaEstudiantes) {
		for (Estudiante estudiante : listaEstudiantes) {
			System.out.println("Datos del Estudiante: "+ estudiante);
		}		
	}
}