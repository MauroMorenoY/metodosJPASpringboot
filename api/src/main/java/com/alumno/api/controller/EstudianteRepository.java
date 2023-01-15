package com.alumno.api.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alumno.api.model.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{

}
