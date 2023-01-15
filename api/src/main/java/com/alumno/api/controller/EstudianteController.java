package com.alumno.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alumno.api.model.Estudiante;

@RestController
@RequestMapping("api")
@CrossOrigin("http://localhost:4200/")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping("estudiante")
	public List<Estudiante> obtenerEstudiantes (){
		
		List<Estudiante> lista = new ArrayList<>();
		Estudiante a = new Estudiante();
				
		a.setId(1);
		a.setNombres("Mauro");
		a.setApellidos("Moreno");
		a.setEmail("algo");
		a.setNota(15.52);
		
		lista.add(a);
		return lista;
	}
	
@PostMapping("guardaestudiante")//definicion de endpoint 
	public Estudiante guardarEstudiante (@RequestBody Estudiante estudiante)//request body para enviar desde un raw json 4
	{
	estudianteService.guardar(estudiante);
		return estudiante;
	}

@GetMapping("verestudiantes")
public List<Estudiante> obtener (){
	return estudianteService.obtenerEstudiantes();
}

@GetMapping("verestudiante/{id}")//el nombre del atributo debe ser el mismo del pathvariable
public Estudiante obtenerEstudiante(@PathVariable("id") Integer id) {
	return estudianteService.obtenerEstudiante(id);
}
	

@PutMapping("actualizar")
public void actualizarEstudiante(@RequestBody Estudiante estudiante) {
	estudianteService.actualizar(estudiante);
}

@DeleteMapping("eliminar/{id}")
public void eliminar (@PathVariable("id") Integer id) {
	estudianteService.eliminar(id);
}
}
