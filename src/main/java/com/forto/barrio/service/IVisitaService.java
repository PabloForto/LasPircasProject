package com.forto.barrio.service;

import java.util.List;

import com.forto.barrio.model.Visita;

/*
 * Interface que implementa los metodos para el servicio de Visitas.
 */

public interface IVisitaService {
	void guardar(Visita visita);
	List<Visita> buscarTodos();
	Visita buscarPorId(Integer idVisita);
	List<Visita> buscarPorNombre(String nombreVisita);
	List<Visita> buscarPorApellido(String apellidoVisita);
	List<Visita> buscarPorDocumento(Integer documentoVisita);
	List<Visita> buscarPorLotePorNumero(String loteVisita, int numeroVisita);
	List<Visita> buscarPorDominio(String dominioVisita);
	void eliminar(Integer idVisita);
}
