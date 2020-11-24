/*
 * Implementacion de los metodos de registros
 */
package com.forto.barrio.service;


import java.util.List;

import com.forto.barrio.model.Propietario;
import com.forto.barrio.model.Registro;
import com.forto.barrio.model.Visita;

public interface IRegistroService {

	List<Registro> buscarTodas();
	Registro generarRegistroConEgreso(Propietario propietario);
	Registro generarIngreso(Integer idRegistro);
	List<Registro> listarhoy();
	List<Registro> listarHoy();
	Registro generarRegistroconIgreso(Visita visita);
	Registro generarEgreso(Integer idRegistro);
	void eliminarRegistro(Integer idRegistro);
	
	
}
