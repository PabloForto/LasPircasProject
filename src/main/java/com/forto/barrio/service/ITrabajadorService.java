package com.forto.barrio.service;

import java.util.List;

import com.forto.barrio.model.Trabajador;

public interface ITrabajadorService {

	void guardar(Trabajador trabajador);
	
	List<Trabajador> buscarTodos();
	
	Trabajador buscarPorId(Integer idTrabajador);
	
	List<Trabajador> buscarPorNonbre(String nombreTrabajador);
	
	List<Trabajador> buscarPorApellido(String apellidoTrabajador);
	
	List<Trabajador> buscarPorDocumento(String documentoTrabajador);
	
	
}
