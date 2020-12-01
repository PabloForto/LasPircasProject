package com.forto.barrio.service;

import java.util.List;

import com.forto.barrio.model.Propietario;
import com.forto.barrio.model.Registro;

/*
 * Interface que implementa los metodos para el servicio de Registro de propietarios.
 */

public interface IRegistroService {

	List<Registro> buscarTodas();

	Registro generarRegistroConEgreso(Propietario propietario);

	Registro generarIngreso(Integer idRegistro);

	List<Registro> listarhoy();

	Registro generarEgreso(Integer idRegistro);

	void eliminarRegistro(Integer idRegistro);

}
