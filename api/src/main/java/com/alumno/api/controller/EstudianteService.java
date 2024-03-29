package com.alumno.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alumno.api.model.Estudiante;

@Service
public class EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianterepository ;
	
	public void guardar(Estudiante estudiante) {
		estudianterepository.save(estudiante);
	}
	
	public List<Estudiante> obtenerEstudiantes (){
		return estudianterepository.findAll();
	}
	
	public Estudiante obtenerEstudiante(Integer id) {//El tipo de la funcion puede ser opcional en ciertos casos
		return estudianterepository.findById(id).get();//findbyid debe implementa el get si es opcional el retorno de cierto tipo
	}
	
	public void actualizar (Estudiante estudiante) {
		estudianterepository.save(estudiante);
	}
	
	public void eliminar (Integer id) {
		estudianterepository.deleteById(id);
	}
}
