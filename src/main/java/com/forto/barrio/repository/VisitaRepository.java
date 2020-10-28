package com.forto.barrio.repository;


import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forto.barrio.model.Visita;

public interface VisitaRepository extends JpaRepository<Visita, Integer> {
	
	//Buscar por Nombre Visita.
	List<Visita> findByNombre(String nombre);
	
	//Buscar por Apellido Visita.
	List<Visita> findByApellido(String apellido);
	
	//Buscar por Documento Visita.
	List<Visita> findByDocumento(Integer documento);
	
	//Buscar por Vehiculo Visita.
	List<Visita> findByVehiculo(String vehiculo);
	
	//Buscar por Dominio(patente del vehiculo) Visita.
	List<Visita> findByDominio(String dominio);
	
	//Buscar por Lote Visita.
	List<Visita> findByLote(String lote);
	
	//Buscar por Numero Visita.
	List<Visita> findByNumero(Integer numero);
	
	//Buscar por Lote y Numero (numero de lote) Visita.
	List<Visita> findByLoteAndNumeroOrderByIdAsc(String lote, int numero);
	
	//Buscar por Nombre y Apellido ordenado por Id ascendente Visita.
	List<Visita> findByNombreAndApellidoOrderByIdAsc(String nombre, String apellido);
	
	//Buscar por Vehiculo y Dominio ordenado por Id ascendente  Visita.	
	List<Visita> findByVehiculoAndDominioOrderByIdAsc(String vehiculo, String dominio);
	
	//Buscar por Nombre , Apellido , Lote , Numero ordenado por Lote ascendente.
	List<Visita> findByNombreAndApellidoAndLoteAndNumeroOrderByLoteAsc(String nombre, String apellido, String lote, int numero);

}
