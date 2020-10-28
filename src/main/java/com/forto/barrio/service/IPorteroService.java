package com.forto.barrio.service;

import java.util.List;

import com.forto.barrio.model.Portero;

public interface IPorteroService {
	
	void guardar(Portero portero);
	List<Portero> buscarTodos();
	Portero buscarPorId(Integer idPortero);
  
}
