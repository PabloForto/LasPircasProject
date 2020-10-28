/*
 * Repositorio de registro 
 */

package com.forto.barrio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forto.barrio.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro,Integer>{
 
	/*
	 * Buscar por fecha 
	 */
	List<Registro> findByRegistro(Date registro);
	List<Registro> findByEgresoBetween(Date first, Date second);
}
