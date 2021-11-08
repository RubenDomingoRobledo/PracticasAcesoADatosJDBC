package com.add.ejercicio4;

import java.util.List;

public interface EstudianteDAO {
	public void insert(Estudiante estudiante);
	public boolean update(Estudiante estudiante);
	public boolean deleteById(Integer id);
	public List<Estudiante> findAll();
	public List<Estudiante> findByName(String name);
	public boolean removeAll();
}
