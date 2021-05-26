package com.forto.barrio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forto.barrio.model.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer>{

	List<Trabajador> findByNombre(String nombre);
	
	List<Trabajador> findByApellido(String apellido);
	
	List<Trabajador> findByDocumento(String Documento);
	
	List<Trabajador> findByCategoria(String categoria);
}
