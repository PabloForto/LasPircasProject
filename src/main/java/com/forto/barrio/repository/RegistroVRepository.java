package com.forto.barrio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forto.barrio.model.RegistroV;

/*
 *Repositorio de Registros de Visitas. 
 */

public interface RegistroVRepository extends JpaRepository<RegistroV, Integer> {

	/*
	 * Lista de Registros encargada de buscar por fechas.
	 */
	List<RegistroV> findByRegistro(Date registro);

	List<RegistroV> findByIngresoBetween(Date first, Date second);

}
