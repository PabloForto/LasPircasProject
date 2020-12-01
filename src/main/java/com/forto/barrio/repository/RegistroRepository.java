package com.forto.barrio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forto.barrio.model.Registro;

/*
 * Repositorio de registro de Propietarios.
 */

public interface RegistroRepository extends JpaRepository<Registro, Integer> {

	/*
	 * Lista de registros para buscar por fecha.
	 */
	List<Registro> findByRegistro(Date registro);

	List<Registro> findByEgresoBetween(Date first, Date second);

	List<Registro> findByIngresoBetween(Date first, Date second);
}
