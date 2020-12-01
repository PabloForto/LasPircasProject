package com.forto.barrio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forto.barrio.model.Propietario;

/*
 * Repositorio Propietario.
 */

public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {

	List<Propietario> findByLote(String lote);

	List<Propietario> findByNumero(Integer numero);

	List<Propietario> findByNombre(String nombre);

	List<Propietario> findByApellido(String apellido);

	List<Propietario> findByDocumento(Integer documento);

	List<Propietario> findByTelefono(Integer telefono);

	List<Propietario> findByVehiculo(String vehiculo);

	List<Propietario> findByDominio(String dominio);

	List<Propietario> findByLoteAndNumeroOrderByLoteAsc(String lote, int numero);

	List<Propietario> findByNombreAndApellidoOrderByIdAsc(String nombre, String apellido);

	List<Propietario> findByLoteAndNumeroAndNombreAndApellidoOrderByLoteAsc(String lote, int numero, String nombre,
			String apellido);

	// Sentencia para saber quienes son propietarios y quien son inquilinos dentro
	// del barrio.
	List<Propietario> findByEstatusIn(Integer[] estatus);

	// Sentencia para buscar por registro si no tiene registro tanto de egreso como
	// ingreso.
	List<Propietario> findByRegistrosIsNullOrRegistrosEgresoIsNotNullAndRegistrosIngresoIsNotNull();

}
