package com.forto.barrio.service;

import java.util.List;

import com.forto.barrio.model.RegistroV;
import com.forto.barrio.model.Visita;

/*
 * Interface que implementa los metodos para el servicio reegistros de visitas.
 */

public interface IRegistroVService {

	List<RegistroV> buscarTodas();

	List<RegistroV> listarhoy();

	RegistroV generarRegistroconIgreso(Visita visita);

	RegistroV generarEgreso(Integer idRegistro);
}
