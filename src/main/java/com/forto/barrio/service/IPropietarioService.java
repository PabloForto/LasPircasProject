package com.forto.barrio.service;

import java.util.List;

import com.forto.barrio.model.Propietario;

/*
 *Interface que implementa los metodos para el servicio Propietarios. 
 */

public interface IPropietarioService {

	void guardar(Propietario propietario);

	List<Propietario> buscarTodos();

	Propietario buscarPorId(Integer idPropietario);

//	List<Propietario> buscarPorLoteYnumero(String lotePropietario, int numeroPropietario);

//	List<Propietario> buscarPorNombre(String nombrePropietario);
//
//	List<Propietario> buscarPorApellido(String apellidoPropietario);
	
	List<Propietario> buscarPorNombreApellido(String nombreApellido);

	List<Propietario> buscarPorDominio(String dominioPropietario);

//	List<Propietario> buscarPorLotePorNumeroPorNombrePorApellido(String lotePropietario, int numeroPropietario,
//			String nombrePropietario, String apellidoPropietario);

//	List<Propietario> buscarPorNombrePorApellido(String nombrePropietario, String apellidoPropietario);

	void eliminar(Integer idPropietario);

}
