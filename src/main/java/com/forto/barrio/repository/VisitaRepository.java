package com.forto.barrio.repository;


import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forto.barrio.model.Visita;

public interface VisitaRepository extends JpaRepository<Visita, Integer> {
	
	List<Visita> findByNombre(String nombre);
	List<Visita> findByApellido(String apellido);
	List<Visita> findByDocumento(Integer documento);
	List<Visita> findByVehiculo(String vehiculo);
	List<Visita> findByDominio(String dominio);
	List<Visita> findByLote(String lote);
	List<Visita> findByNumero(Integer numero);
	List<Visita> findByLoteAndNumeroOrderByIdAsc(String lote, int numero);
	List<Visita> findByNombreAndApellidoOrderByIdAsc(String nombre, String apellido);
	List<Visita> findByVehiculoAndDominioOrderByIdAsc(String vehiculo, String dominio);
	List<Visita> findByNombreAndApellidoAndLoteAndNumeroOrderByLoteAsc(String nombre, String apellido, String lote, int numero);
	//Sentencia para buscar por registro si no tiene registro tanto de egreso como ingreso.	
	List<Visita>findByRegistrosIsNullOrRegistrosEgresoIsNotNullAndRegistrosIngresoIsNotNull();
	
}
